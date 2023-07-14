package com.chiwawa.lionheart.domain.domain.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.articlebookmark.ArticleBookmark;
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

	@Column(name = "MEMBER_ROLE", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private MemberRole role;

	@Column(name = "FCM_TOKEN", length = 300)
	private String fcmToken;

	@Column(name = "PROFILE_IMAGE_URL", length = 300)
	private String profileImageUrl;

	@OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Onboarding onboarding;

	@OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Setting setting;

	@OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Challenge challenge;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<Attendance> attendances = new ArrayList<>();

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ArticleBookmark> articleBookmarks = new ArrayList<>();

	public static Member newInstance(String socialId, MemberSocialType socialType, String fcmToken) {
		return Member.builder()
			.socialInfo(SocialInfo.of(socialId, socialType))
			.role(MemberRole.MEMBER)
			.fcmToken(fcmToken)
			.build();
	}

	public void setOnboarding(Onboarding onboarding) {
		this.onboarding = onboarding;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public void updateFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
}
