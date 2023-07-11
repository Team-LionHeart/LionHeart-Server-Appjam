package com.chiwawa.lionheart.common.exception;

public class BadGatewayException extends LionHeartException {

	public BadGatewayException(String message) {
		super(message, ErrorCode.BAD_GATEWAY_EXCEPTION);
	}

}
