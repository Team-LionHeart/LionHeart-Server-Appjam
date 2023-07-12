package com.chiwawa.lionheart.domain.domain.article.repository;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;

public interface ArticleRepositoryCustom {

	Optional<Article> findArticleById(Long id);
}