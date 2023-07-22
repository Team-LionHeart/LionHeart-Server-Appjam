package com.chiwawa.lionheart.api.service.articlebookmark.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateArticleBookmarkRequest {
	@Schema(description = "아티클 아이디")
	private Long articleId;

	@Schema(description = "북마크 요청 상태")
	private boolean bookmarkRequestStatus;
}