package com.chiwawa.lionheart.notification.config.scheduler;

import org.springframework.util.ErrorHandler;

import com.chiwawa.lionheart.common.exception.model.BadGatewayException;
import com.chiwawa.lionheart.common.exception.model.InternalServerException;
import com.chiwawa.lionheart.common.exception.model.LionHeartException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchedulerErrorHandler implements ErrorHandler {

	@Override
	public void handleError(Throwable throwable) {
		if (throwable instanceof LionHeartException) {
			LionHeartException exception = (LionHeartException)throwable;
			if (exception instanceof InternalServerException || exception instanceof BadGatewayException) {
				log.error(exception.getMessage(), exception);
			} else {
				log.warn(exception.getMessage(), exception);
			}
		} else {
			Exception exception = (Exception)throwable;
			log.error(exception.getMessage(), exception);
		}
	}
}
