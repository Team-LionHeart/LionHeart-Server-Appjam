package com.chiwawa.lionheart.domain.domain.article.articleTag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.article.articleTag.ArticleTag;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long>, ArticleTagRepositoryCustom {
}
