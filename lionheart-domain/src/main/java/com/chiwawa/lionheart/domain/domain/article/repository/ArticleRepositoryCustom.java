package com.chiwawa.lionheart.domain.domain.article.repository;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.Category;

public interface ArticleRepositoryCustom {

	List<Article> findArticlesByCategory(Category category);
}
