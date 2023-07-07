package com.chiwawa.lionheart.api.config.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.common.constant.JwtKey;
import com.chiwawa.lionheart.common.exception.InternalServerException;

@Component
public class MemberIdResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(MemberId.class) && Long.class.equals(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
		if (parameter.getMethodAnnotation(Auth.class) == null) {
			throw new InternalServerException("인증이 필요한 컨트롤러 입니다. @Auth 어노테이션을 붙여주세요.");
		}
		Object object = webRequest.getAttribute(JwtKey.MEMBER_ID, 0);
		if (object == null) {
			throw new InternalServerException(
				String.format("USER_ID를 가져오지 못했습니다. (%s - %s)", parameter.getClass(), parameter.getMethod()));
		}
		return object;
	}
}
