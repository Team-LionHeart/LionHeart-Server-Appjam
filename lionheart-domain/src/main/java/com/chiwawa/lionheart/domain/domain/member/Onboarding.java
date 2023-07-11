package com.chiwawa.lionheart.domain.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.common.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ONBOARDING")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Onboarding extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ONBOARDING_ID")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID", nullable = true)
	private Member member;

	@Column(name = "PREGNANT_WEEKS", nullable = false)
	private byte pregnantWeeks;

	@Column(name = "BABY_NICKNAME", nullable = false, length = 30)
	private String babyNickname;

	public static Onboarding newInstance(Member member, byte pregnantWeeks, String babyNickname) {
		return builder()
			.member(member)
			.pregnantWeeks(pregnantWeeks)
			.babyNickname(babyNickname)
			.build();
	}
}
