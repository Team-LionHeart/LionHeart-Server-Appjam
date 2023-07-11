package com.chiwawa.lionheart.common.exception;

public class ConflictException extends LionHeartException {

	public ConflictException(String message) {
		super(message, ErrorCode.CONFLICT_EXCEPTION);
	}

	public ConflictException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
