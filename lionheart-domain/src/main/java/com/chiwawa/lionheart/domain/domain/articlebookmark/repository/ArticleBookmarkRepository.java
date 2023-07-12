package com.chiwawa.lionheart.domain.domain.articlebookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;

public interface ArticleBookmarkRepository
	extends JpaRepository<ArticleBookmark, Long>, ArticleBookmarkRepositoryCustom {
}
