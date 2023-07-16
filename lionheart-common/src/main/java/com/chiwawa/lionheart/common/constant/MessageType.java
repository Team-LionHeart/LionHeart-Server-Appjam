package com.chiwawa.lionheart.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageType {

	public static final String MESSAGE_TYPE_HEADER = "TYPE";
	public static final String FIREBASE = "FIREBASE";
	public static final String SLACK = "SLACK";
}
