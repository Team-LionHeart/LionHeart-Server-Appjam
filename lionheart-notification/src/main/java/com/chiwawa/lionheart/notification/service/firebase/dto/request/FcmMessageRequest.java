package com.chiwawa.lionheart.notification.service.firebase.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FcmMessageRequest {
	private boolean validateOnly;
	private Message message;

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Message {
		private Notification notification;
		private Android android;
		private Apns apns;
		private String token;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Notification {
		private String title;
		private String body;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Android {
		private Data data;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Data {
		private String title;
		private String body;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Apns {
		private Payload payload;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Payload {
		private Aps aps;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Aps {
		private Alert alert;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Alert {
		private String title;
		private String body;
	}

	public static FcmMessageRequest of(String targetToken, String title, String body) {
		return FcmMessageRequest.builder()
			.validateOnly(false)
			.message(FcmMessageRequest.Message.builder()
				.notification(FcmMessageRequest.Notification.builder()
					.title(title)
					.body(body)
					.build())
				.android(FcmMessageRequest.Android.builder()
					.data(FcmMessageRequest.Data.builder()
						.title(title)
						.body(body)
						.build())
					.build())
				.apns(FcmMessageRequest.Apns.builder()
					.payload(FcmMessageRequest.Payload.builder()
						.aps(FcmMessageRequest.Aps.builder()
							.alert(FcmMessageRequest.Alert.builder()
								.title(title)
								.body(body)
								.build())
							.build())
						.build())
					.build())
				.token(targetToken)
				.build())
			.build();
	}
}
