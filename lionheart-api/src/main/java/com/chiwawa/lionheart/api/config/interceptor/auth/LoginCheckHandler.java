package com.chiwawa.lionheart.api.config.interceptor.auth;

import static com.chiwawa.lionheart.common.constant.message.AuthErrorMessage.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.chiwawa.lionheart.common.exception.model.UnAuthorizedException;
import com.chiwawa.lionheart.common.util.JwtUtils;
import com.chiwawa.lionheart.common.util.StringUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class LoginCheckHandler {

	private final JwtUtils jwtUtils;

	public Long getMemberId(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (org.springframework.util.StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			String accessToken = bearerToken.substring("Bearer ".length());
			if (jwtUtils.validateToken(accessToken)) {
				Long memberId = jwtUtils.getMemberIdFromJwt(accessToken);
				if (memberId != null) {
					return memberId;
				}
			}
		}
		throw new UnAuthorizedException(StringUtils.generateString(WRONG_JWT_ERROR_MESSAGE, bearerToken));
	}
}
