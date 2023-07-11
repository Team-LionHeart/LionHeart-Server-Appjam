package com.chiwawa.lionheart.common.exception.model;

import com.chiwawa.lionheart.common.exception.ErrorCode;

public class NotFoundException extends LionHeartException {

	public NotFoundException(String message) {
		super(message, ErrorCode.NOT_FOUND_EXCEPTION);
	}

	public NotFoundException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
