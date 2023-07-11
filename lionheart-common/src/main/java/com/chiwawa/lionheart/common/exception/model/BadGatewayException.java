package com.chiwawa.lionheart.common.exception.model;

import com.chiwawa.lionheart.common.exception.ErrorCode;

public class BadGatewayException extends LionHeartException {

	public BadGatewayException(String message) {
		super(message, ErrorCode.BAD_GATEWAY_EXCEPTION);
	}

}
