package com.chiwawa.lionheart.common.exception;

public class UnAuthorizedException extends BlossomException {

	public UnAuthorizedException(String message) {
		super(message, ErrorCode.UNAUTHORIZED_EXCEPTION);
	}

}
