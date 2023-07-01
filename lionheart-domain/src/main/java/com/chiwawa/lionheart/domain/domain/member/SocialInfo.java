package com.chiwawa.lionheart.domain.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class SocialInfo {

	@Column(name = "SOCIAL_ID", nullable = false, length = 300)
	private String socialId;

	@Column(name = "SOCIAL_TYPE", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private MemberSocialType socialType;

	private SocialInfo(String socialId, MemberSocialType socialType) {
		this.socialId = socialId;
		this.socialType = socialType;
	}

	public static SocialInfo of(String socialId, MemberSocialType socialType) {
		return new SocialInfo(socialId, socialType);
	}
}
