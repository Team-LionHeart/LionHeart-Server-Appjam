package com.chiwawa.lionheart.common.exception.model;

import com.chiwawa.lionheart.common.exception.ErrorCode;

public class ValidationException extends LionHeartException {

	public ValidationException(String message) {
		super(message, ErrorCode.VALIDATION_EXCEPTION);
	}

	public ValidationException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
