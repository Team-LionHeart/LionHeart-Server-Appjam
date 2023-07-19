package com.chiwawa.lionheart.domain.domain.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.article.articleContent.ArticleContent;
import com.chiwawa.lionheart.domain.domain.article.articleTag.ArticleTag;
import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
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

	@Column(name = "ARTICLE_TYPE", nullable = false, length = 30)
	@Enumerated(value = EnumType.STRING)
	private ArticleType articleType;

	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;

	@Column(name = "CATEGORY", length = 30)
	@Enumerated(value = EnumType.STRING)
	private Category category;

	@Column(name = "MAIN_IMAGE_URL", nullable = false, length = 300)
	private String mainImageUrl;

	@Column(name = "MAIN_IMAGE_CAPTION", nullable = false, length = 100)
	private String mainImageCaption;

	@Column(name = "AUTHOR", nullable = false, length = 30)
	private String author;

	@Column(name = "WEEK")
	private Short week;

	@Column(name = "DAY")
	private Short day;

	@Column(name = "REQUIRED_TIME", nullable = false)
	private short requiredTime;

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleContent> articleContents = new ArrayList<>();

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleTag> articleTags = new ArrayList<>();

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleBookmark> articleBookmarks = new ArrayList<>();
}
