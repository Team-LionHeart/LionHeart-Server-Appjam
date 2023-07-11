package com.chiwawa.lionheart.common.exception;

import lombok.Getter;

@Getter
public abstract class LionHeartException extends RuntimeException {

	private ErrorCode errorCode;

	public LionHeartException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public LionHeartException(String message) {
		super(message);
	}

}
