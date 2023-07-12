package com.chiwawa.lionheart.api.controller.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.member.MemberRetrieveService;
import com.chiwawa.lionheart.api.service.member.dto.response.ProfileResponse;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Member")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberRetrieveController {

	private final MemberRetrieveService memberRetrieveService;

	@Operation(summary = "[인증] 프로필 조회")
	@Auth
	@GetMapping("/member/profile")
	public ApiResponse<ProfileResponse> getProfile(@MemberId Long memberId) {
		return ApiResponse.success(memberRetrieveService.getProfile(memberId));
	}
}
