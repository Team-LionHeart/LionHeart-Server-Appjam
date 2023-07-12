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
public class CategoryArticleResponse {

	@Schema(description = "카테코리 별 아티클 정보")
	private List<CategoryArticleDto> categoryArticles;

	public static CategoryArticleResponse of(List<CategoryArticleDto> categoryArticles) {
		return CategoryArticleResponse
			.builder()
			.categoryArticles(categoryArticles)
			.build();
	}
}
