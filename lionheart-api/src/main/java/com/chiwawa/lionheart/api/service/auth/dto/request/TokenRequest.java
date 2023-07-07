package com.chiwawa.lionheart.api.service.auth.dto.request;

import javax.validation.constraints.NotBlank;

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
public class TokenRequest {

	@Schema(description = "토큰 - accessToken", example = "eyJhbGciOiJIUzUxMiJ9.udnKnDSK08EuX56E5k-")
	@NotBlank(message = "{auth.accessToken.notBlank}")
	private String accessToken;

	@Schema(description = "토큰 - refreshToken", example = "eyJhbGciOiJIUzUxMiJ9.udnKnDSK08EuX56E5k-")
	@NotBlank(message = "{auth.refreshToken.notBlank}")
	private String refreshToken;
}
