package com.chiwawa.lionheart.domain.domain.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.common.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ARTICLE_IMAGE")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ArticleImage extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARTICLE_IMAGE_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLE_ID", nullable = false)
	private Article article;

	@Column(name = "ARTICLE_IMAGE_URL", nullable = false, length = 300)
	private String articleImageUrl;

	@Column(name = "IMAGE_DESCRIPTION", nullable = false, length = 100)
	private String imageDescription;

	@Column(name = "IMAGE_ORDER", nullable = false)
	private byte imageOrder;
}
