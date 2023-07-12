package com.chiwawa.lionheart.domain.domain.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.article.articlebookmark.ArticleBookmark;
import com.chiwawa.lionheart.domain.domain.challenge.Attendance;
import com.chiwawa.lionheart.domain.domain.challenge.Challenge;
import com.chiwawa.lionheart.domain.domain.common.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "MEMBER")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;

	@Embedded
	private SocialInfo socialInfo;

	@Column(name = "FCM_TOKEN", length = 300)
	private String fcmToken;

	@Column(name = "PROFILE_IMAGE_URL", length = 300)
	private String profileImageUrl;

	@OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Onboarding onboarding;

	@OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Challenge challenge;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<Attendance> attendances = new ArrayList<>();

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleBookmark> articleBookmarks = new ArrayList<>();

	public static Member newInstance(String socialId, MemberSocialType socialType) {
		return Member.builder()
			.socialInfo(SocialInfo.of(socialId, socialType))
			.fcmToken("")
			.build();
	}
}
