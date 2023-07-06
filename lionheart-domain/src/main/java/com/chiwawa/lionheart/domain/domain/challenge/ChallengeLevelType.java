package com.chiwawa.lionheart.domain.domain.challenge;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChallengeLevelType {
	LEVEL_ONE("1단계"),
	LEVEL_TWO("2단계"),
	LEVEL_THREE("3단계"),
	LEVEL_FOUR("4단계"),
	COMPLETE("챌린지 완료");

	private final String value;
}
