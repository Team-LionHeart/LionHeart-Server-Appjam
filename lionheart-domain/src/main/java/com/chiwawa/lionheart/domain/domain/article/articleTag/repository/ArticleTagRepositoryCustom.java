package com.chiwawa.lionheart.domain.domain.article.articleTag.repository;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleTag.ArticleTag;

public interface ArticleTagRepositoryCustom {

	List<ArticleTag> findArticleTagsByArticle(Article article);
}
