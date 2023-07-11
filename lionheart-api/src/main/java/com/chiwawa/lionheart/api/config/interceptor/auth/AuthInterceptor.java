package com.chiwawa.lionheart.api.config.interceptor.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.chiwawa.lionheart.common.constant.JwtKey;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AuthInterceptor implements HandlerInterceptor {

	private final LoginCheckHandler loginCheckHandler;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Optional<Auth> auth = Optional.ofNullable(handlerMethod.getMethodAnnotation(Auth.class));
		if (auth.isEmpty()) {
			return true;
		}
		Long memberId = loginCheckHandler.getMemberId(request);
		request.setAttribute(JwtKey.MEMBER_ID, memberId);
		return true;
	}
}