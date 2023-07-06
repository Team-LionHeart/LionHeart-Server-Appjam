package com.chiwawa.lionheart.domain.domain.challenge;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChallengePopupType {
	START("도전하기");

	private final String value;
}
