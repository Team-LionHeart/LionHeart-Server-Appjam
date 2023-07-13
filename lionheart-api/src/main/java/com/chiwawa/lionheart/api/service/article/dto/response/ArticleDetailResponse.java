package com.chiwawa.lionheart.api.service.article.dto.response;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.article.Article;

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
public class ArticleDetailResponse {

	private String title;
	private String author;
	private String mainImageUrl;
	private String mainImageCaption;
	private Boolean isMarked;
	private List<ArticleContentDto> contents;

	public static ArticleDetailResponse of(Article article, boolean isMarked, List<ArticleContentDto> contents) {
		return ArticleDetailResponse.builder()
			.title(article.getTitle())
			.author(article.getAuthor())
			.mainImageUrl(article.getMainImageUrl())
			.mainImageCaption(article.getMainImageCaption())
			.isMarked(isMarked)
			.contents(contents)
			.build();
	}
}
