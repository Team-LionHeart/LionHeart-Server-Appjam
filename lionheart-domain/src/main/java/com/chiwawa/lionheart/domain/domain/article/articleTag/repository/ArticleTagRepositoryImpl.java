package com.chiwawa.lionheart.domain.domain.article.articleTag.repository;

import static com.chiwawa.lionheart.domain.domain.article.articleTag.QArticleTag.*;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleTag.ArticleTag;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleTagRepositoryImpl implements ArticleTagRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<ArticleTag> findArticleTagByArticle(Article article) {
		return queryFactory
			.selectFrom(articleTag)
			.where(articleTag.article.eq(article))
			.fetch();
	}
}
