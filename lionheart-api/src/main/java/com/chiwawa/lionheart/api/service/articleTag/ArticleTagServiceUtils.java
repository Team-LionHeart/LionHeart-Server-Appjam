package com.chiwawa.lionheart.api.service.articleTag;

import java.util.List;
import java.util.stream.Collectors;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleTag.ArticleTag;
import com.chiwawa.lionheart.domain.domain.article.articleTag.repository.ArticleTagRepository;

public class ArticleTagServiceUtils {

	public static List<String> findArticleTagByArticle(ArticleTagRepository articleTagRepository, Article article) {
		List<ArticleTag> articleTags = articleTagRepository.findArticleTagByArticle(article);

		return articleTags.stream()
			.map(tag -> tag.getTagName())
			.collect(Collectors.toList());
	}
}
