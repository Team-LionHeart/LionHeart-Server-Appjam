package com.chiwawa.lionheart.domain.domain.article;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ArticleType {

	CATEGORY("카테고리"),
	WEEK_DAY("주차, 일차"),
	;

	private final String type;
}
