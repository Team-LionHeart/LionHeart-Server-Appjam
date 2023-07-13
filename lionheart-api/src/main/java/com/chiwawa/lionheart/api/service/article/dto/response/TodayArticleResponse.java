package com.chiwawa.lionheart.api.service.article.dto.response;

import com.chiwawa.lionheart.common.dto.WeekAndDay;
import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.member.Onboarding;

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

	private String babyNickname;
	private String title;
	private String mainImageUrl;
	private String editorNoteContent;
	private int week;
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
