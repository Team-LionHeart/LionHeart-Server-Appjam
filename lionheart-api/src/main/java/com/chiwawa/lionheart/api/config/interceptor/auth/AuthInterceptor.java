package com.chiwawa.lionheart.api.config.interceptor.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.chiwawa.lionheart.common.constant.JwtKey;

import lombok.RequiredArgsConstructor;

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
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		if (auth == null) {
			return true;
		}
		Long userId = loginCheckHandler.getUserId(request);
		request.setAttribute(JwtKey.MEMBER_ID, userId);
		return true;
	}
}