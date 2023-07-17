package com.chiwawa.lionheart.api.controller.article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.article.ArticleRetrieveService;
import com.chiwawa.lionheart.api.service.article.dto.response.ArticleDetailResponse;
import com.chiwawa.lionheart.api.service.article.dto.response.ArticleSummaryResponse;
import com.chiwawa.lionheart.api.service.article.dto.response.TodayArticleResponse;
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

	@Operation(summary = "[인증] 카테고리 별 아티클 조회")
	@Auth
	@GetMapping("/article")
	public ApiResponse<ArticleSummaryResponse> findArticlesByCategory(
		@MemberId final Long memberId,
		@Parameter(description = "카테고리명", required = true, example = "BUDGET") @RequestParam final Category category) {

		return ApiResponse.success(articleService.findArticlesByCategory(memberId, category));
	}

	@Operation(summary = "[인증] 투데이 아티클 조회")
	@Auth
	@GetMapping("/article/today")
	public ApiResponse<TodayArticleResponse> findTodayArticle(@MemberId final Long memberId) {
		return ApiResponse.success(articleService.findTodayArticleByMemberId(memberId));
	}

	@Operation(summary = "[인증] 주차별 아티클 조회")
	@Auth
	@GetMapping("/article/week/{week}")
	public ApiResponse<ArticleSummaryResponse> findArticlesOfWeek(
		@MemberId final Long memberId,
		@Parameter(description = "주차", required = true, example = "1") @PathVariable final short week) {
		return ApiResponse.success(articleService.findArticlesByWeekAndMemberId(memberId, week));
	}

	@Operation(summary = "[인증] 아티클 상세 조회")
	@Auth
	@GetMapping("/article/{articleId}")
	public ApiResponse<ArticleDetailResponse> findTodayArticle(
		@MemberId final Long memberId,
		@Parameter(description = "아티클ID", required = true, example = "1") @PathVariable final Long articleId) {
		return ApiResponse.success(articleService.findArticleDetail(memberId, articleId));
	}

}
