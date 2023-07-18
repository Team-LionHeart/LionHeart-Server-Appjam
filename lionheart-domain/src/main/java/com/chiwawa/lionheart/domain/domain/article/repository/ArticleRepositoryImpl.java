package com.chiwawa.lionheart.domain.domain.article.repository;

import static com.chiwawa.lionheart.domain.domain.article.QArticle.*;

import java.util.List;
import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.ArticleType;
import com.chiwawa.lionheart.domain.domain.article.Category;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<Article> findArticleById(Long id) {
		return Optional.ofNullable(queryFactory
			.selectFrom(article)
			.where(article.id.eq(id))
			.fetchOne());
	}

	@Override
	public List<Article> findArticlesByCategory(Category category) {
		return queryFactory
			.selectFrom(article)
			.where(
				article.articleType.eq(ArticleType.CATEGORY),
				article.category.eq(category)
			)
			.fetch();
	}

	@Override
	public Optional<Article> findArticleByWeekAndDay(short week, short day) {
		return Optional.ofNullable(queryFactory
			.selectFrom(article)
			.where(
				article.articleType.eq(ArticleType.WEEK_DAY),
				article.week.eq(week),
				article.day.eq(day))
			.fetchOne());
	}

	@Override
	public List<Article> findOrderedArticlesByWeek(short week) {
		return queryFactory
			.selectFrom(article)
			.where(
				article.articleType.eq(ArticleType.WEEK_DAY),
				article.week.eq(week)
			)
			.orderBy(article.day.asc())
			.fetch();
	}

}
