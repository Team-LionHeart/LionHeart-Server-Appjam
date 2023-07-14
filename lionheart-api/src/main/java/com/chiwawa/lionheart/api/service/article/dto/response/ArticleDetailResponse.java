package com.chiwawa.lionheart.api.service.article.dto.response;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.article.Article;

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
public class ArticleDetailResponse {

	@Schema(description = "제목")
	private String title;

	@Schema(description = "저자")
	private String author;

	@Schema(description = "메인 이미지 URL")
	private String mainImageUrl;

	@Schema(description = "메인 이미지 캡션")
	private String mainImageCaption;

	@Schema(description = "북마크 여부")
	private Boolean isMarked;

	@Schema(description = "내용")
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
