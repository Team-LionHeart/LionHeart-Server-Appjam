package com.chiwawa.lionheart.common.exception.model;

import com.chiwawa.lionheart.common.exception.ErrorCode;

public class ForbiddenException extends LionHeartException {

	public ForbiddenException(String message) {
		super(message, ErrorCode.FORBIDDEN_EXCEPTION);
	}

	public ForbiddenException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
