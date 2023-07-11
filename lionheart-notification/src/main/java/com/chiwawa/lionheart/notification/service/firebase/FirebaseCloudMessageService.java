package com.chiwawa.lionheart.notification.service.firebase;

import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.chiwawa.lionheart.common.exception.InternalServerException;
import com.chiwawa.lionheart.external.client.firebase.FirebaseApiCaller;
import com.chiwawa.lionheart.notification.service.firebase.dto.request.FcmMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class FirebaseCloudMessageService {

	@Value("${cloud.firebase.config.path}")
	private String firebaseConfigPath;

	private final ObjectMapper objectMapper;
	private final FirebaseApiCaller firebaseApiCaller;

	public void sendMessageTo(String fcmToken, String title, String body) {
		try {
			String message = makeMessage(fcmToken, title, body);
			firebaseApiCaller.requestFcmMessaging(getAccessToken(), message);
		} catch (Exception exception) {
			// fcm token 갱신 필요
			log.error(exception.getMessage(), exception);
		}
	}

	private String makeMessage(String targetToken, String title, String body) {
		FcmMessageRequest fcmMessage = FcmMessageRequest.of(targetToken, title, body);
		try {
			return objectMapper.writeValueAsString(fcmMessage);
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			throw new InternalServerException("FCM makeMessage exception", INTERNAL_SERVER_EXCEPTION);
		}
	}

	private String getAccessToken() {
		try {
			GoogleCredentials googleCredentials = GoogleCredentials
				.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())
				.createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));
			googleCredentials.refreshIfExpired();
			return googleCredentials.getAccessToken().getTokenValue();
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			throw new InternalServerException("FCM getAccessToken exception", INTERNAL_SERVER_EXCEPTION);
		}
	}
}
