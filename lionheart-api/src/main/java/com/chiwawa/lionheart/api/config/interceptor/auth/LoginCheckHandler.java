package com.chiwawa.lionheart.api.config.interceptor.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.chiwawa.lionheart.common.exception.UnAuthorizedException;
import com.chiwawa.lionheart.common.util.JwtUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class LoginCheckHandler {

	private final JwtUtils jwtUtils;

	public Long getUserId(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			String accessToken = bearerToken.substring("Bearer ".length());
			if (jwtUtils.validateToken(accessToken)) {
				Long userId = jwtUtils.getMemberIdFromJwt(accessToken);
				if (userId != null) {
					return userId;
				}
			}
		}
		throw new UnAuthorizedException(String.format("잘못된 JWT (%s) 입니다.", bearerToken));
	}
}
