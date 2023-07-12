package com.chiwawa.lionheart.api.service.article;

import static com.chiwawa.lionheart.common.constant.message.CategoryErrorMessage.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.article.articleTag.ArticleTagServiceUtils;
import com.chiwawa.lionheart.api.service.article.dto.response.CategoryArticleDto;
import com.chiwawa.lionheart.api.service.article.dto.response.CategoryArticleResponse;
import com.chiwawa.lionheart.common.exception.ErrorCode;
import com.chiwawa.lionheart.common.exception.NotFoundException;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.Category;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.article.articleContent.repository.ArticleContentRepository;
import com.chiwawa.lionheart.domain.domain.article.articleTag.repository.ArticleTagRepository;
import com.chiwawa.lionheart.domain.domain.article.repository.ArticleRepository;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.articlebookmark.repository.ArticleBookmarkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleRetrieveService {

	private final ArticleRepository articleRepository;
	private final ArticleBookmarkRepository articleBookmarkRepository;
	private final ArticleContentRepository articleContentRepository;
	private final ArticleTagRepository articleTagRepository;

	public CategoryArticleResponse findArticlesByCategory(Long memberId, Category category) {

		List<CategoryArticleDto> categoryArticles = articleRepository.findArticleByCategory(category)
			.stream()
			.map(c -> formatCategoryArticleResponse(memberId, c))
			.collect(Collectors.toList());

		Collections.shuffle(categoryArticles);
		return CategoryArticleResponse.of(categoryArticles);
	}

	private CategoryArticleDto formatCategoryArticleResponse(Long memberId, Article article) {
		Optional<ArticleBookmark> bookmark = articleBookmarkRepository.findArticleBookmarkByMemberAndArticle(
			memberId, article);

		ArticleContent content = articleContentRepository.findArticleFirstContentByArticle(article)
			.orElseThrow(() -> new NotFoundException(
				MessageUtils.generate(NOT_EXIST_ARTICLE_CONTENT_ERROR_MESSAGE, article.getId()),
				ErrorCode.NOT_FOUND_ARTICLE_CONTENT_EXCEPTION));

		List<String> articleTags = ArticleTagServiceUtils.findArticleTagsByArticle(articleTagRepository, article);

		return CategoryArticleDto.of(article, content, articleTags, bookmark.isPresent());
	}

}
