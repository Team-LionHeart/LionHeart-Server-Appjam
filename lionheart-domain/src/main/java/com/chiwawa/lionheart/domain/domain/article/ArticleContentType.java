package com.chiwawa.lionheart.domain.domain.article;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ArticleContentType {
	H1("헤딩1"),
	H2("헤딩2");

	private final String value;
}
