package com.chiwawa.lionheart.api.config.interceptor.admin;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AdminInterceptor implements HandlerInterceptor {

	private final AdminCheckHandler adminCheckHandler;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Optional<Admin> admin = Optional.ofNullable(handlerMethod.getMethodAnnotation(Admin.class));
		if (admin.isEmpty()) {
			return true;
		}
		adminCheckHandler.validateMemberRole(request);
		return true;
	}
}