package com.chiwawa.lionheart.domain.domain.article.articleContent.repository;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;

public interface ArticleContentRepositoryCustom {

	Optional<ArticleContent> findFirstContentByArticle(Article article);
}
