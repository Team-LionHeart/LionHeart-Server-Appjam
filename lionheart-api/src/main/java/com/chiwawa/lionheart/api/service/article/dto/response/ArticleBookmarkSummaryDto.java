package com.chiwawa.lionheart.api.service.article.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;

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
public class ArticleBookmarkSummaryDto {

	private String title;
	private String mainImageUrl;
	private Boolean isMarked;
	private List<String> tags;

	public static ArticleBookmarkSummaryDto of(ArticleBookmark articleBookmark) {
		Article article = articleBookmark.getArticle();
		return ArticleBookmarkSummaryDto.builder()
			.title(article.getTitle())
			.mainImageUrl(article.getMainImageUrl())
			.tags(article.getArticleTags()
				.stream()
				.map(articleTag -> articleTag.getTagName())
				.collect(Collectors.toList()))
			.isMarked(true)
			.build();
	}
}
