package com.chiwawa.lionheart.api.controller.article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.article.ArticleRetrieveService;
import com.chiwawa.lionheart.api.service.article.dto.response.CategoryArticleResponse;
import com.chiwawa.lionheart.common.dto.ApiResponse;
import com.chiwawa.lionheart.domain.domain.article.Category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Article")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ArticleRetrieveController {

	private final ArticleRetrieveService articleService;

	@Operation(summary = "카테고리 별 아티클 조회")
	@Auth
	@GetMapping("/article")
	public ApiResponse<CategoryArticleResponse> findArticlesByCategory(
		@MemberId final Long memberId,
		@Parameter(description = "카테고리명", required = true, example = "BUDGET") @RequestParam final Category category) {

		return ApiResponse.success(articleService.findArticlesByCategory(memberId, category));
	}

}
