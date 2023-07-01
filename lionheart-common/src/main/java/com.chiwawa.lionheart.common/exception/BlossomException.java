package com.chiwawa.lionheart.common.exception;

import lombok.Getter;

@Getter
public abstract class BlossomException extends RuntimeException {

	private ErrorCode errorCode;

	public BlossomException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BlossomException(String message) {
		super(message);
	}

}
