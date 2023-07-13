package com.chiwawa.lionheart.api.service.article.dto.response;

import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContentType;

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
public class ArticleContentDto {

	private String content;
	private String caption;
	private ArticleContentType type;

	public static ArticleContentDto of(ArticleContent articleContent) {
		return ArticleContentDto.builder()
			.content(articleContent.getContent())
			.caption(articleContent.getCaption())
			.type(articleContent.getType())
			.build();
	}
}
