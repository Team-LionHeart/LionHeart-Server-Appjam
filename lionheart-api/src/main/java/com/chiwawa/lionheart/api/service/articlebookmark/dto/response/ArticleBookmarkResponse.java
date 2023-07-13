package com.chiwawa.lionheart.api.service.articlebookmark.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.member.Member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ArticleBookmarkResponse {
	@Schema(description = "태명")
	private String babyNickname;

	@Schema(description = "북마크 한 아티클 정보")
	private List<ArticleSummaryDto> articleSummaries;

	public static ArticleBookmarkResponse of(Member member, List<ArticleBookmark> articleBookmarks) {
		return ArticleBookmarkResponse
			.builder()
			.babyNickname(member.getOnboarding().getBabyNickname())
			.articleSummaries(articleBookmarks
				.stream()
				.map(articleBookmark -> ArticleSummaryDto.of(articleBookmark, member))
				.collect(Collectors.toList()))
			.build();
	}
}