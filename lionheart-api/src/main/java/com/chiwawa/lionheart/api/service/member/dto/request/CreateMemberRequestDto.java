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
public class CreateMemberRequestDto {

	private String socialId;
	private MemberSocialType socialType;

	public static CreateMemberRequestDto of(String socialId, MemberSocialType socialType) {
		return CreateMemberRequestDto.builder()
			.socialId(socialId)
			.socialType(socialType)
			.build();
	}
}
