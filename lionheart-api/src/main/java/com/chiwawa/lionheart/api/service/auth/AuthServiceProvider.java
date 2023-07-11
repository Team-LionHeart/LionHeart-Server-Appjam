package com.chiwawa.lionheart.api.service.auth;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.chiwawa.lionheart.api.service.auth.impl.KakaoAuthService;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuthServiceProvider {

	private static final Map<MemberSocialType, AuthService> authServiceMap = new HashMap<>();

	private final KakaoAuthService kakaoAuthService;

	@PostConstruct
	void initializeAuthServicesMap() {
		authServiceMap.put(MemberSocialType.KAKAO, kakaoAuthService);
	}

	public AuthService getAuthService(MemberSocialType socialType) {
		return authServiceMap.get(socialType);
	}
}
