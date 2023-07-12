package com.chiwawa.lionheart.domain.domain.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.challenge.Challenge;

public interface ArticleRepository extends JpaRepository<Challenge, Long>, ArticleRepositoryCustom {
}
