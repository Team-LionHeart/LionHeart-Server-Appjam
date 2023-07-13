package com.chiwawa.lionheart.api.controller.articlebookmark;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.config.interceptor.auth.Auth;
import com.chiwawa.lionheart.api.config.resolver.MemberId;
import com.chiwawa.lionheart.api.service.articlebookmark.ArticleBookmarkService;
import com.chiwawa.lionheart.api.service.articlebookmark.dto.request.UpdateArticleBookmarkRequest;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "ArticleBookmark")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ArticleBookmarkController {

	private final ArticleBookmarkService articleBookmarkService;

	@Operation(summary = "아티클 북마크 생성")
	@Auth
	@PostMapping("/article/bookmark")
	public ApiResponse<String> updateArticleBookmark(@MemberId Long memberId, @Valid @RequestBody
	UpdateArticleBookmarkRequest request) {
		articleBookmarkService.updateArticleBookmark(memberId, request);
		return ApiResponse.SUCCESS;
	}
}