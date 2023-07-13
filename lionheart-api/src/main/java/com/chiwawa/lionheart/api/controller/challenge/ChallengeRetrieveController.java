package com.chiwawa.lionheart.api.controller.challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.challenge.ChallengeRetrieveService;
import com.chiwawa.lionheart.api.service.challenge.dto.response.ChallengeProgressResponse;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Challenge")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ChallengeRetrieveController {

	private final ChallengeRetrieveService challengeRetrieveService;

	@Operation(summary = "[인증] 챌린지 진척도 조회")
	@Auth
	@GetMapping("/challenge/progress")
	public ApiResponse<ChallengeProgressResponse> getChallengeProgress(@MemberId Long memberId) {
		return ApiResponse.success(challengeRetrieveService.getChallengeProgress(memberId));
	}
}
