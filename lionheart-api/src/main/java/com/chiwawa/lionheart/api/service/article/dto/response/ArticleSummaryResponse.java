package com.chiwawa.lionheart.api.service.article.dto.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ArticleSummaryResponse {

	@Schema(description = "아티클 요약 정보")
	private List<ArticleSummaryDto> articleSummaries;

	public static ArticleSummaryResponse of(List<ArticleSummaryDto> articleSummaries) {
		return ArticleSummaryResponse
			.builder()
			.articleSummaries(articleSummaries)
			.build();
	}
}
