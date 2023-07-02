package com.chiwawa.lionheart.common.exception;

public class UnAuthorizedException extends LionHeartException {

	public UnAuthorizedException(String message) {
		super(message, ErrorCode.UNAUTHORIZED_EXCEPTION);
	}

}
