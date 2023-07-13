package com.chiwawa.lionheart.api.service.articlebookmark.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.member.Member;

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
public class ArticleSummaryDto {
	private String title;
	private String mainImageUrl;
	private List<String> tags;
	private boolean bookmarkStatus;

	public static ArticleSummaryDto of(ArticleBookmark articleBookmark, Member member) {
		Article article = articleBookmark.getArticle();
		return ArticleSummaryDto.builder()
			.title(article.getTitle())
			.mainImageUrl(article.getMainImageUrl())
			.tags(article.getArticleTags()
				.stream()
				.map(articleTag -> articleTag.getTagName())
				.collect(Collectors.toList()))
			.bookmarkStatus(articleBookmark.getMember().getId().equals(member.getId()))
			.build();
	}
}
