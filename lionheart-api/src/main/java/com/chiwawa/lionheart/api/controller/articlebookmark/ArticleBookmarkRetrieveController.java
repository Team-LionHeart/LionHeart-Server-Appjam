package com.chiwawa.lionheart.api.controller.articlebookmark;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.articlebookmark.ArticleBookmarkRetrieveService;
import com.chiwawa.lionheart.api.service.articlebookmark.dto.response.ArticleBookmarkResponse;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "ArticleBookmark")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ArticleBookmarkRetrieveController {

	private final ArticleBookmarkRetrieveService articleBookmarkRetrieveService;

	@Operation(summary = "아티클 북마크 목 조회")
	@Auth
	@GetMapping("/article/bookmarks")
	public ApiResponse<ArticleBookmarkResponse> getArticleBookmark(@MemberId Long memberId) {
		return ApiResponse.success(articleBookmarkRetrieveService.getArticleBookmark(memberId));
	}
}