package com.chiwawa.lionheart.api.service.article;

import static com.chiwawa.lionheart.common.constant.message.ArticleErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import com.chiwawa.lionheart.common.dto.WeekAndDay;
import com.chiwawa.lionheart.common.exception.model.NotFoundException;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.repository.ArticleRepository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleServiceUtils {

	public static Article findArticleByWeekAndDay(ArticleRepository articleRepository, WeekAndDay weekAndDay) {
		return articleRepository.findArticleByWeekAndDay(weekAndDay.getWeek(), weekAndDay.getDay())
			.orElseThrow(() ->
				new NotFoundException(
					MessageUtils.generate(NOT_EXIST_ARTICLE_IN_WEEK_AND_DAY_MESSAGE, weekAndDay.getWeek(),
						weekAndDay.getDay()),
					NOT_FOUND_ARTICLE_IN_WEEK_AND_DAY_EXCEPTION));
	}

	public static Article findArticleById(ArticleRepository articleRepository, Long articleId) {
		return articleRepository.findArticleById(articleId)
			.orElseThrow(() ->
				new NotFoundException(
					MessageUtils.generate(NOT_EXIST_ARTICLE_ID_ERROR_MESSAGE, articleId),
					NOT_FOUND_ARTICLE_EXCEPTION));
	}
}
