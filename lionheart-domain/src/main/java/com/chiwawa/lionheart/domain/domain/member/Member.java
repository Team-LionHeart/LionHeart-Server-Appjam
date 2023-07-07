package com.chiwawa.lionheart.domain.domain.member;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "NICKNAME", nullable = false, length = 30)
	private String nickname;

	public static Member newInstance(String socialId, MemberSocialType socialType) {
		return Member.builder()
			.socialInfo(SocialInfo.of(socialId, socialType))
			.fcmToken("")
			.nickname("")
			.build();
	}
}
