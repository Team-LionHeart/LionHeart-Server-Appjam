package com.chiwawa.lionheart.domain.domain.article.articlebookmark.repository;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articlebookmark.ArticleBookmark;

public interface ArticleBookmarkRepositoryCustom {

	Optional<ArticleBookmark> findByMemberIdAndArticleId(Long memberId, Article article);
}
