package com.chiwawa.lionheart.common.dto.sqs;

import com.chiwawa.lionheart.common.constant.MessageType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class SlackDto extends MessageDto {

	private Exception error;
	private String requestMethod;
	private String requestURI;

	public static SlackDto of(Exception error, String requestMethod, String requestURI) {
		return SlackDto.builder()
			.type(MessageType.SLACK)
			.error(error)
			.requestMethod(requestMethod)
			.requestURI(requestURI)
			.build();
	}
}
