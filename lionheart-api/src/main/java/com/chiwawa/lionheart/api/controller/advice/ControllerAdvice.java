package com.chiwawa.lionheart.api.controller.advice;

import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chiwawa.lionheart.api.controller.notification.dto.request.SlackNotificationRequest;
import com.chiwawa.lionheart.api.service.notification.NotificationService;
import com.chiwawa.lionheart.common.dto.ApiResponse;
import com.chiwawa.lionheart.common.exception.model.BadGatewayException;
import com.chiwawa.lionheart.common.exception.model.ConflictException;
import com.chiwawa.lionheart.common.exception.model.ForbiddenException;
import com.chiwawa.lionheart.common.exception.model.NotFoundException;
import com.chiwawa.lionheart.common.exception.model.UnAuthorizedException;
import com.chiwawa.lionheart.common.exception.model.ValidationException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerAdvice {

	private final NotificationService notificationService;

	/**
	 * 400 BadRequest
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	protected ApiResponse<Object> handleBadRequest(BindException exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(VALIDATION_EXCEPTION,
			Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ApiResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(VALIDATION_EXCEPTION,
			Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({
		HttpMessageNotReadableException.class,
		InvalidFormatException.class,
		ServletRequestBindingException.class
	})
	protected ApiResponse<Object> handleInvalidFormatException(final Exception exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(VALIDATION_EXCEPTION);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	protected ApiResponse<Object> handleValidationException(final ValidationException exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(exception.getErrorCode());
	}

	/**
	 * 401 UnAuthorized
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UnAuthorizedException.class)
	protected ApiResponse<Object> handleUnAuthorizedException(final UnAuthorizedException exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(exception.getErrorCode());
	}

	/**
	 * 403 Forbidden
	 */
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(ForbiddenException.class)
	protected ApiResponse<Object> handleForbiddenException(final ForbiddenException exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(exception.getErrorCode());
	}

	/**
	 * 404 NotFound
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	protected ApiResponse<Object> handleNotFoundException(final NotFoundException exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(exception.getErrorCode());
	}

	/**
	 * 405 Method Not Supported
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ApiResponse<Object> handleHttpRequestMethodNotSupportedException(
		HttpRequestMethodNotSupportedException exception) {
		return ApiResponse.error(METHOD_NOT_ALLOWED_EXCEPTION);
	}

	/**
	 * 409 Conflict
	 */
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ConflictException.class)
	protected ApiResponse<Object> handleConflictException(final ConflictException exception) {
		log.error(exception.getMessage(), exception);
		return ApiResponse.error(exception.getErrorCode());
	}

	/**
	 * 415 UnSupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeException.class)
	protected ApiResponse<Object> handleHttpMediaTypeException(final HttpMediaTypeException exception) {
		return ApiResponse.error(UNSUPPORTED_MEDIA_TYPE);
	}

	/**
	 * 502 Bad Gateway
	 */
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(BadGatewayException.class)
	protected ApiResponse<Object> handleBadGatewayException(final BadGatewayException exception,
		final HttpServletRequest request) {
		log.error(exception.getMessage(), exception);
		notificationService.sendCustomNotificationToSlack(SlackNotificationRequest.of(exception, request));
		return ApiResponse.error(exception.getErrorCode());
	}

	/**
	 * 500 Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	protected ApiResponse<Object> handleException(final Exception exception, final HttpServletRequest request) {
		log.error(exception.getMessage(), exception);
		notificationService.sendCustomNotificationToSlack(SlackNotificationRequest.of(exception, request));
		return ApiResponse.error(INTERNAL_SERVER_EXCEPTION);
	}
}
