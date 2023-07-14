package com.chiwawa.lionheart.domain.domain.article.repository;

import java.util.List;
import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.Category;

public interface ArticleRepositoryCustom {

	List<Article> findArticlesByCategory(Category category);

	Optional<Article> findArticleByWeekAndDay(short week, short day);

	List<Article> findOrderedArticlesByWeek(short week);

	Optional<Article> findArticleById(Long id);

}

