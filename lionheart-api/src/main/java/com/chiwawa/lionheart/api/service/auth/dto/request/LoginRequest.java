package com.chiwawa.lionheart.api.service.auth.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class LoginRequest {

	@Schema(description = "소셜 로그인 타입", example = "KAKAO")
	@NotNull(message = "{auth.socialType.notNull}")
	private MemberSocialType socialType;

	@Schema(description = "소셜 토큰", example = "eyJhbGciOiJIUzUxdfadfadsMiJ9.udnKnDSK08EuX56E5k-")
	@NotBlank(message = "{auth.token.notBlank}")
	private String token;
}
