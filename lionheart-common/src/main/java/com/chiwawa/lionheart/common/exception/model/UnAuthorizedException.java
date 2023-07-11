package com.chiwawa.lionheart.common.exception.model;

import com.chiwawa.lionheart.common.exception.ErrorCode;

public class UnAuthorizedException extends LionHeartException {

	public UnAuthorizedException(String message) {
		super(message, ErrorCode.UNAUTHORIZED_EXCEPTION);
	}

}
