package com.chiwawa.lionheart.domain.domain.article;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Category {
	BUDGET("예산"),
	PHYSICAL_CHANGE("신체 변화"),
	MARITAL_RELATIONSHIP("부부 관계"),
	HOSPITAL_INFORMATION("병원 정보"),
	SUPPORT_SYSTEM("지원 제도"),
	PRENATAL_EDUCATION("태교"),
	BABY_GOODS("아기 용품"),
	DAD_TIPS("아빠들의 팁"),
	;

	private final String value;
}
