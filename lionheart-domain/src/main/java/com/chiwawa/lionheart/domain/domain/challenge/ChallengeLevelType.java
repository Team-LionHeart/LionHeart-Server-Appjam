package com.chiwawa.lionheart.domain.domain.challenge;

import java.util.Arrays;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChallengeLevelType {
	LEVEL_ONE(1, "1단계"),
	LEVEL_TWO(2, "2단계"),
	LEVEL_THREE(3, "3단계"),
	LEVEL_FOUR(4, "4단계"),
	LEVEL_FIVE(5, "5단계");

	private final int level;
	private final String value;

	public static ChallengeLevelType find(int level) {
		return Arrays.stream(values())
			.filter(t -> t.level == level)
			.findFirst()
			.orElse(LEVEL_FIVE);
	}
}
