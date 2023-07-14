package com.chiwawa.lionheart.domain.domain.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.notification.TodayArticleNotification;

public interface TodayArticleNotificationRepository
	extends JpaRepository<TodayArticleNotification, Long>, TodayArticleNotificationRepositoryCustom {
}
