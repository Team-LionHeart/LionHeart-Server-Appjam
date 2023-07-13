package com.chiwawa.lionheart.api.service.article.dto.response;

import com.chiwawa.lionheart.common.dto.WeekAndDay;
import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.member.Onboarding;

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
public class TodayArticleResponse {

	@Schema(description = "태명")
	private String babyNickname;

	@Schema(description = "아티클 제목")
	private String title;

	@Schema(description = "메인 이미지 URL")
	private String mainImageUrl;

	@Schema(description = "에디터 노트 컨텐츠")
	private String editorNoteContent;

	@Schema(description = "주차")
	private int week;

	@Schema(description = "일차")
	private int day;

	public static TodayArticleResponse of(Article article, Onboarding onboarding, WeekAndDay weekAndDay,
		ArticleContent editorNoteContent) {
		return TodayArticleResponse.builder()
			.babyNickname(onboarding.getBabyNickname())
			.title(article.getTitle())
			.mainImageUrl(article.getMainImageUrl())
			.editorNoteContent(editorNoteContent.getContent())
			.week(weekAndDay.getWeek())
			.day(weekAndDay.getDay())
			.build();

	}

}
