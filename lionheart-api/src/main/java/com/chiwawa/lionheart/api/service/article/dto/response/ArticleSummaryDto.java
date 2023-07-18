package com.chiwawa.lionheart.api.service.article.dto.response;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.article.Article;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;

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

	private Long articleId;
	private String title;
	private String mainImageUrl;
	private String firstBodyContent;
	private int requiredTime;
	private Boolean isMarked;
	private List<String> tags;

	public static ArticleSummaryDto of(Article article, ArticleContent content, List<String> tag,
		boolean isMarked) {
		return ArticleSummaryDto.builder()
			.articleId(article.getId())
			.title(article.getTitle())
			.mainImageUrl(article.getMainImageUrl())
			.requiredTime(article.getRequiredTime())
			.firstBodyContent(content.getContent())
			.isMarked(isMarked)
			.tags(tag)
			.build();
	}
}
