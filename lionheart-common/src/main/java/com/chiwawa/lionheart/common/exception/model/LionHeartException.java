package com.chiwawa.lionheart.common.exception.model;

import com.chiwawa.lionheart.common.exception.ErrorCode;

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
