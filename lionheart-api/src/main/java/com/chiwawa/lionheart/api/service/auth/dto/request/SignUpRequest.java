package com.chiwawa.lionheart.api.service.auth.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.chiwawa.lionheart.api.service.member.dto.request.CreateMemberRequestDto;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpRequest {

	@Schema(description = "소셜 로그인 타입", example = "KAKAO")
	@NotNull(message = "{auth.socialType.notNull}")
	private MemberSocialType socialType;

	@Schema(description = "소셜 토큰", example = "eyJhbGciOiJIUzUxdfadfadsMiJ9.udnKnDSK08EuX56E5k-")
	@NotBlank(message = "{auth.token.notBlank}")
	private String token;

	@Schema(description = "fcm 토큰", example = "dfdafjdslkfjslfjslifsjvmdsklvdosijsmvsdjvosadjvosd")
	@NotBlank(message = "{auth.fcmToken.notBlank}")
	private String fcmToken;

	@Schema(description = "임신 주차", example = "23")
	@Min(value = 1, message = "{onboarding.pregnantWeeks.min}")
	@Max(value = 40, message = "{onboarding.pregnantWeeks.max}")
	@NotNull(message = "{onboarding.pregnantWeeks.notNull}")
	private byte pregnantWeeks;

	@Schema(description = "태명", example = "금쪽이")
	@Size(min = 1, max = 10, message = "{onboarding.babyNickname.size}")
	@NotNull(message = "{onboarding.babyNickname.notNull}")
	private String babyNickname;

	public CreateMemberRequestDto toCreateUserDto(String socialId) {
		return CreateMemberRequestDto.of(socialId, socialType, fcmToken, pregnantWeeks, babyNickname);
	}
}
