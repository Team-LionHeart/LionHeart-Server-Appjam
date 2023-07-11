package com.chiwawa.lionheart.api.config.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.common.constant.JwtKey;
import com.chiwawa.lionheart.common.exception.model.InternalServerException;

import java.util.Optional;

import static com.chiwawa.lionheart.common.constant.message.AuthErrorMessage.CAN_NOT_GET_MEMBER_ID_ERROR_MESSAGE;
import static com.chiwawa.lionheart.common.constant.message.AuthErrorMessage.NEED_AUTH_ANNOTATION_ERROR_MESSAGE;
import static com.chiwawa.lionheart.common.util.ErrorMessageUtil.generateMessage;

@Component
public class MemberIdResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(MemberId.class) && Long.class.equals(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
		Optional<Auth> auth = Optional.ofNullable(parameter.getMethodAnnotation(Auth.class));
		auth.orElseThrow(() -> new InternalServerException(NEED_AUTH_ANNOTATION_ERROR_MESSAGE));

		Optional<Object> object = Optional.ofNullable(webRequest.getAttribute(JwtKey.MEMBER_ID, 0));
		return object.orElseThrow(() -> new InternalServerException(
				generateMessage(CAN_NOT_GET_MEMBER_ID_ERROR_MESSAGE, parameter.getClass(), parameter.getMethod())));

	}
}
