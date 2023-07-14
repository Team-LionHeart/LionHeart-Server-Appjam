package com.chiwawa.lionheart.domain.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberRole {
	ADMIN("관리자"),
	MEMBER("회원");

	private final String value;
}
