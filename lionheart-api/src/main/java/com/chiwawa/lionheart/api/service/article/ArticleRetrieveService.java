package com.chiwawa.lionheart.api.service.article;

import static com.chiwawa.lionheart.common.constant.message.CategoryErrorMessage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.article.dto.response.CategoryArticleDto;
import com.chiwawa.lionheart.api.service.article.dto.response.CategoryArticleResponse;
import com.chiwawa.lionheart.api.service.articleTag.ArticleTagServiceUtils;
import com.chiwawa.lionheart.common.exception.ErrorCode;
import com.chiwawa.lionheart.common.exception.NotFoundException;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.Category;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.article.articleContent.repository.ArticleContentRepository;
import com.chiwawa.lionheart.domain.domain.article.articleTag.repository.ArticleTagRepository;
import com.chiwawa.lionheart.domain.domain.article.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.article.articlebookmark.repository.ArticleBookmarkRepository;
import com.chiwawa.lionheart.domain.domain.article.repository.ArticleRepository;

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
		List<CategoryArticleDto> categoryArticles = new ArrayList<>();

		List<Article> articles = articleRepository.findByCategory(category);
		for (Article article : articles) {
			categoryArticles.add(formatCategoryArticleResponse(memberId, article));
		}

		Collections.shuffle(categoryArticles);
		return CategoryArticleResponse.of(categoryArticles);
	}

	private CategoryArticleDto formatCategoryArticleResponse(Long memberId, Article article) {
		Optional<ArticleBookmark> bookmark = articleBookmarkRepository.findByMemberIdAndArticleId(
			memberId, article);

		ArticleContent content = articleContentRepository.findFirstContentByArticle(article)
			.orElseThrow(() -> new NotFoundException(
				MessageUtils.generate(NOT_EXIST_ARTICLE_CONTENT_ERROR_MESSAGE, article.getId()),
				ErrorCode.NOT_FOUND_ARTICLE_CONTENT_EXCEPTION));

		List<String> articleTags = ArticleTagServiceUtils.findArticleTagByArticle(articleTagRepository, article);

		return CategoryArticleDto.of(article, content, articleTags, bookmark.isPresent());
	}

}
