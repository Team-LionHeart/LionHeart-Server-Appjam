package com.chiwawa.lionheart.domain.domain.article.repository;

import static com.chiwawa.lionheart.domain.domain.article.QArticle.*;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
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
}
