package com.chiwawa.lionheart.api.service.article.articleTag;

import java.util.List;
import java.util.stream.Collectors;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleTag.ArticleTag;

public class ArticleTagServiceUtils {

	public static List<String> findArticleTagsByArticle(Article article) {

		return article.getArticleTags().stream()
			.map(ArticleTag::getTagName)
			.collect(Collectors.toList());
	}
}
