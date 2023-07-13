package com.chiwawa.lionheart.api.service.member.dto.request;

import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class CreateMemberRequest {

	private String socialId;
	private MemberSocialType socialType;
	private String fcmToken;
	private short pregnantWeeks;
	private String babyNickname;

	public static CreateMemberRequest of(String socialId, MemberSocialType socialType, String fcmToken,
		short pregnantWeeks, String babyNickname) {
		return CreateMemberRequest.builder()
			.socialId(socialId)
			.socialType(socialType)
			.fcmToken(fcmToken)
			.pregnantWeeks(pregnantWeeks)
			.babyNickname(babyNickname)
			.build();
	}
}
