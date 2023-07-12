package com.chiwawa.lionheart.domain.domain.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.article.articleTag.ArticleTag;
import com.chiwawa.lionheart.domain.domain.article.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.common.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ARTICLE")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Article extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARTICLE_ID")
	private Long id;

	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;

	@Column(name = "CATEGORY", nullable = false, length = 30)
	private Category category;

	@Column(name = "MAIN_IMAGE_URL", nullable = false, length = 300)
	private String mainImageUrl;

	@Column(name = "MAIN_IMAGE_CAPTION", nullable = false, length = 100)
	private String mainImageCaption;

	@Column(name = "AUTHOR", nullable = false, length = 30)
	private String author;

	@Column(name = "WEEK", nullable = false)
	private byte week;

	@Column(name = "DAY", nullable = false)
	private byte day;

	@Column(name = "TIME", nullable = false)
	private byte time;

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleContent> articleContents = new ArrayList<>();

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleTag> articleTags = new ArrayList<>();

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleBookmark> articleBookmarks = new ArrayList<>();
}
