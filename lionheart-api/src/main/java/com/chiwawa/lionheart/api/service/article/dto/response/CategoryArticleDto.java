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
public class CategoryArticleDto {

	private String title;
	private String content;
	private int time;
	private Boolean isMarked;
	private List<String> tag;

	public static CategoryArticleDto of(Article article, ArticleContent content, List<String> tag,
		boolean isMarked) {
		return CategoryArticleDto.builder()
			.title(article.getTitle())
			.content(content.getContent())
			.time(article.getTime())
			.isMarked(isMarked)
			.tag(tag)
			.build();
	}
}
