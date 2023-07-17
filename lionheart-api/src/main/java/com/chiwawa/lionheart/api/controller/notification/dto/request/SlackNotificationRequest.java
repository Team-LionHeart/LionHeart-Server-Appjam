package com.chiwawa.lionheart.api.controller.notification.dto.request;

import javax.servlet.http.HttpServletRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class SlackNotificationRequest {

	private String requestMethod;
	private String requestUri;
	private Exception error;

	public static SlackNotificationRequest of(Exception error, HttpServletRequest request) {
		return SlackNotificationRequest.builder()
			.error(error)
			.requestMethod(request.getMethod())
			.requestUri(request.getRequestURI())
			.build();
	}
}
