package com.chiwawa.lionheart.domain.domain.notification.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TodayArticleNotificationRepositoryImpl implements TodayArticleNotificationRepositoryCustom {

	private final JPAQueryFactory queryFactory;

}
