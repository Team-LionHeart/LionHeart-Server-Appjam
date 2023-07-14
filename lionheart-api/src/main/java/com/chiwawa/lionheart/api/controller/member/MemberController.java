package com.chiwawa.lionheart.api.controller.member;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.member.MemberService;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Member")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

	private final MemberService memberService;

	@Operation(summary = "[인증] 회원 탈퇴")
	@Auth
	@DeleteMapping("/member")
	public ApiResponse<String> deleteMember(@MemberId Long memberId) {
		memberService.deleteMember(memberId);
		return ApiResponse.SUCCESS;
	}
}
