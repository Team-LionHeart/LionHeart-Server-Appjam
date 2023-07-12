package com.chiwawa.lionheart.domain.domain.article.repository;

import static com.chiwawa.lionheart.domain.domain.article.QArticle.*;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.Category;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Article> findArticleByCategory(Category category) {
		return queryFactory
			.selectFrom(article)
			.where(article.category.eq(category))
			.fetch();
	}
}
