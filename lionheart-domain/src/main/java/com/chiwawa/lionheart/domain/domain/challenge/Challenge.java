package com.chiwawa.lionheart.domain.domain.challenge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chiwawa.lionheart.domain.domain.common.BaseEntity;
import com.chiwawa.lionheart.domain.domain.member.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "CHALLENGE")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Challenge extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHALLENGE_ID")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;

	@Column(name = "LEVEL", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private ChallengeLevelType level;

	private static final int LEVEL_UP_STANDARD = 5;
  
	public static Challenge newInstance(Member member) {
		return Challenge.builder()
			.member(member)
			.level(ChallengeLevelType.LEVEL_ONE)
			.build();
	}

	public void levelUp(int attendanceCheckCount) {
		int level = (attendanceCheckCount % LEVEL_UP_STANDARD) + 1;
		this.level = ChallengeLevelType.find(level);
	}

}
