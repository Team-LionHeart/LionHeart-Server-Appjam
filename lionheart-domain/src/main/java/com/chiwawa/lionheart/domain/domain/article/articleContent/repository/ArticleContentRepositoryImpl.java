package com.chiwawa.lionheart.domain.domain.article.articleContent.repository;

import static com.chiwawa.lionheart.domain.domain.article.articleContent.QArticleContent.*;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContentType;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleContentRepositoryImpl implements ArticleContentRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<ArticleContent> findArticleFirstBodyByArticle(Article article) {
		return Optional.ofNullable(queryFactory
			.selectFrom(articleContent)
			.where(articleContent.article.eq(article))
			.where(articleContent.type.eq(ArticleContentType.BODY))
			.orderBy(articleContent.order.asc())
			.fetchFirst());
	}

}
