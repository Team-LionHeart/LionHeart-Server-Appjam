package com.chiwawa.lionheart.common.exception;

public class NotFoundException extends BlossomException {

	public NotFoundException(String message) {
		super(message, ErrorCode.NOT_FOUND_EXCEPTION);
	}

	public NotFoundException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
