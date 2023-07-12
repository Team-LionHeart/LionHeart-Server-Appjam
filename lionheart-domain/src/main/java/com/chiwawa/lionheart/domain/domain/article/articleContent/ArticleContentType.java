package com.chiwawa.lionheart.domain.domain.article.articleContent;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ArticleContentType {
	EDITOR_NOTE("에디터 노트"),
	CHAPTER_TITLE("챕터 타이틀"),
	GENERAL_TITLE("본문 타이틀"),
	BODY("바디"),
	IMAGE("이미지"),
	;

	private final String value;
}
