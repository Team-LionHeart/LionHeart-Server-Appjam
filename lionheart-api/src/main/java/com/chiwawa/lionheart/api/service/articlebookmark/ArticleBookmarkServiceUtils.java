package com.chiwawa.lionheart.api.service.articlebookmark;

import static com.chiwawa.lionheart.common.constant.message.ArticleBookmarkErrorMessage.*;
import static com.chiwawa.lionheart.common.constant.message.ArticleErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import java.util.Optional;

import com.chiwawa.lionheart.common.exception.model.ConflictException;
import com.chiwawa.lionheart.common.exception.model.NotFoundException;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.repository.ArticleRepository;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleBookmarkServiceUtils {
	//TODO: Article 로 폴더 이동
	public static Article findArticleById(ArticleRepository articleRepository, Long articleId) {
		Optional<Article> article = articleRepository.findArticleById(articleId);
		return article.orElseThrow(() ->
			new NotFoundException(MessageUtils.generate(NOT_EXIST_ARTICLE_ID_ERROR_MESSAGE, articleId),
				NOT_FOUND_ARTICLE_EXCEPTION));
	}

	public static void validateBookmarkRequest(Optional<ArticleBookmark> articleBookmark, boolean bookmarkStatus) {
		if (bookmarkStatus == true && articleBookmark.isPresent()) {
			throw new ConflictException(
				MessageUtils.generate(ALREADY_EXIST_BOOKMARK_ERROR_MESSAGE, articleBookmark.get().getId()),
				CONFLICT_BOOKMARK_EXCEPTION);
		}
		if (bookmarkStatus == false && articleBookmark.isEmpty()) {
			throw new ConflictException(ALREADY_EMPTY_BOOKMARK_ERROR_MESSAGE, CONFLICT_BOOKMARK_EXCEPTION);
		}
	}
}