package com.chiwawa.lionheart.domain.domain.articlebookmark.repository;

import java.util.List;
import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.member.Member;

public interface ArticleBookmarkRepositoryCustom {

	Optional<ArticleBookmark> findArticleBookmarkByMemberAndArticle(Member member, Article article);

	List<ArticleBookmark> findArticleBookmarksByMember(Member member);
}


