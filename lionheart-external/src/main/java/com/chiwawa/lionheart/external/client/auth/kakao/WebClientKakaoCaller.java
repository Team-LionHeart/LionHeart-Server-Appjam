package com.chiwawa.lionheart.external.client.auth.kakao;

import static com.chiwawa.lionheart.common.constant.message.AuthErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.chiwawa.lionheart.common.exception.model.BadGatewayException;
import com.chiwawa.lionheart.common.exception.model.ValidationException;
import com.chiwawa.lionheart.common.util.StringUtils;
import com.chiwawa.lionheart.external.client.auth.kakao.dto.response.KakaoProfileResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class WebClientKakaoCaller implements KakaoApiCaller {

	private final WebClient webClient;

	@Override
	public KakaoProfileResponse getProfileInfo(String accessToken) {
		return webClient.get()
			.uri("https://kapi.kakao.com/v2/user/me")
			.headers(headers -> headers.setBearerAuth(accessToken))
			.retrieve()
			.onStatus(HttpStatus::is4xxClientError, clientResponse ->
				Mono.error(new ValidationException(
					StringUtils.generateString(WRONG_KAKAO_ACCESS_TOKEN_ERROR_MESSAGE, accessToken),
					VALIDATION_INVALID_TOKEN_EXCEPTION)))
			.onStatus(HttpStatus::is5xxServerError, clientResponse ->
				Mono.error(new BadGatewayException(KAKAO_LOGIN_ERROR_MESSAGE)))
			.bodyToMono(KakaoProfileResponse.class)
			.block();
	}

}
