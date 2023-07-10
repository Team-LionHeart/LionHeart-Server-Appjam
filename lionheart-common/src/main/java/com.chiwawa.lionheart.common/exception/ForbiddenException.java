package com.chiwawa.lionheart.common.exception;

public class ForbiddenException extends LionHeartException {

	public ForbiddenException(String message) {
		super(message, ErrorCode.FORBIDDEN_EXCEPTION);
	}

	public ForbiddenException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}