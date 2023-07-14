package com.chiwawa.lionheart.domain.domain.articlebookmark.repository;

import static com.chiwawa.lionheart.domain.domain.articlebookmark.QArticleBookmark.*;

import java.util.List;
import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleBookmarkRepositoryImpl implements ArticleBookmarkRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<ArticleBookmark> findArticleBookmarkByMemberAndArticle(Member member, Article article) {
		return Optional.ofNullable(queryFactory
			.selectFrom(articleBookmark)
			.where(
				articleBookmark.member.eq(member),
				articleBookmark.article.eq(article))
			.fetchOne());
	}

	@Override
	public List<ArticleBookmark> findArticleBookmarksByMember(Member member) {
		return queryFactory
			.selectFrom(articleBookmark)
			.where(articleBookmark.member.eq(member))
			.fetch();
	}
}
