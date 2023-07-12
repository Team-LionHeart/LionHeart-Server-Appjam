package com.chiwawa.lionheart.api.controller.curriculum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.curriculum.CurriculumRetrieveService;
import com.chiwawa.lionheart.api.service.curriculum.dto.response.CurriculumProgressResponse;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Curriculum")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CurriculumRetrieveController {

	private final CurriculumRetrieveService curriculumRetrieveService;

	@Operation(summary = "[인증] 커리큘럼 진척도 조회")
	@Auth
	@GetMapping("/curriculum/progress")
	public ApiResponse<CurriculumProgressResponse> getCurriculumProgress(@MemberId Long memberId) {
		return ApiResponse.success(curriculumRetrieveService.getCurriculumProgress(memberId));
	}
}
