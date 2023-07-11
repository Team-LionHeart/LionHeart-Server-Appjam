package com.chiwawa.lionheart.api.controller.auth;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.auth.AuthService;
import com.chiwawa.lionheart.api.service.auth.AuthServiceProvider;
import com.chiwawa.lionheart.api.service.auth.CommonAuthService;
import com.chiwawa.lionheart.api.service.auth.CreateTokenService;
import com.chiwawa.lionheart.api.service.auth.dto.request.LoginRequest;
import com.chiwawa.lionheart.api.service.auth.dto.request.SignUpRequest;
import com.chiwawa.lionheart.api.service.auth.dto.request.TokenRequest;
import com.chiwawa.lionheart.api.service.auth.dto.response.TokenResponse;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Auth")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

	private final AuthServiceProvider authServiceProvider;
	private final CreateTokenService createTokenService;
	private final CommonAuthService commonAuthService;

	@Operation(summary = "카카오 소셜 회원가입")
	@PostMapping("/auth/signup")
	public ApiResponse<TokenResponse> signUp(@Valid @RequestBody SignUpRequest request) {
		AuthService authService = authServiceProvider.getAuthService(request.getSocialType());
		Long memberId = authService.signUp(request);
		TokenResponse tokenInfo = createTokenService.createTokenInfo(memberId);
		return ApiResponse.success(tokenInfo);
	}

	@Operation(summary = "카카오 소셜 로그인")
	@PostMapping("/auth/login")
	public ApiResponse<TokenResponse> login(@Valid @RequestBody LoginRequest request) {
		AuthService authService = authServiceProvider.getAuthService(request.getSocialType());
		Long memberId = authService.login(request);
		TokenResponse tokenInfo = createTokenService.createTokenInfo(memberId);
		return ApiResponse.success(tokenInfo);
	}

	@Operation(summary = "[인증] 로그아웃")
	@Auth
	@PostMapping("/auth/logout")
	public ApiResponse<String> logout(@MemberId Long memberId) {
		commonAuthService.logout(memberId);
		return ApiResponse.SUCCESS;
	}

	@Operation(summary = "JWT 토큰 갱신")
	@PostMapping("/auth/reissue")
	public ApiResponse<TokenResponse> reissue(@Valid @RequestBody TokenRequest request) {
		return ApiResponse.success(createTokenService.reissueToken(request));
	}
}
