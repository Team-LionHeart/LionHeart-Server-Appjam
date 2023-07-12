package com.chiwawa.lionheart.domain.domain.article.articleContent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;

public interface ArticleContentRepository extends JpaRepository<ArticleBookmark, Long>,
	ArticleContentRepositoryCustom {
}
