package com.chiwawa.lionheart.api.service.auth.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class TokenResponse {

	@Schema(description = "라이옹 서버 jwt access token")
	private String accessToken;

	@Schema(description = "라이옹 서버 jwt refresh token")
	private String refreshToken;

	public static TokenResponse of(String accessToken, String refreshToken) {
		return TokenResponse.builder()
			.accessToken(accessToken)
			.refreshToken(refreshToken)
			.build();
	}
}
