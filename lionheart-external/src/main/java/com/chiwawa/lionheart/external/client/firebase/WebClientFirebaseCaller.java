package com.chiwawa.lionheart.external.client.firebase;

import static com.chiwawa.lionheart.common.constant.message.FirebaseErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.chiwawa.lionheart.common.exception.model.BadGatewayException;
import com.chiwawa.lionheart.common.exception.model.ValidationException;
import com.chiwawa.lionheart.common.util.MessageUtils;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class WebClientFirebaseCaller implements FirebaseApiCaller {

	private final WebClient webClient;

	@Value("${cloud.firebase.credentials.uri}")
	private String uri;

	@Override
	public void requestFcmMessaging(String accessToken, String requestBody) {
		webClient.post()
			.uri(uri)
			.headers(headers -> {
				headers.setBearerAuth(accessToken);
				headers.setContentType(MediaType.APPLICATION_JSON);
			})
			.body(BodyInserters.fromValue(requestBody))
			.retrieve()
			.onStatus(HttpStatus::is4xxClientError, clientResponse ->
				Mono.error(new ValidationException(
					MessageUtils.generate(WRONG_FIREBASE_ACCESS_TOKEN_ERROR_MESSAGE, accessToken),
					VALIDATION_INVALID_TOKEN_EXCEPTION)))
			.onStatus(HttpStatus::is5xxServerError, clientResponse ->
				Mono.error(new BadGatewayException(FIREBASE_INTERLOCK_ERROR_MESSAGE)))
			.toBodilessEntity()
			.block();
	}
}
