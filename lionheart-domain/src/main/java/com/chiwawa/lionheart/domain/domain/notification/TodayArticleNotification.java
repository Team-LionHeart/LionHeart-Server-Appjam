package com.chiwawa.lionheart.domain.domain.notification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.common.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "TODAY_ARTICLE_NOTIFICATION")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class TodayArticleNotification extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TODAY_ARTICLE_NOTIFICATION_ID")
	private Long id;

	@Column(name = "WEEK", nullable = false)
	private short week;

	@Column(name = "DAY", nullable = false)
	private short day;

	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;

	@Column(name = "BODY", nullable = false, length = 100)
	private String body;
}
