package com.chiwawa.lionheart.api.service.challenge.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.chiwawa.lionheart.domain.domain.challenge.Attendance;
import com.chiwawa.lionheart.domain.domain.challenge.Challenge;
import com.chiwawa.lionheart.domain.domain.challenge.ChallengeLevelType;
import com.chiwawa.lionheart.domain.domain.member.Member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ChallengeProgressResponse {

	@Schema(description = "태명")
	private String babyNickname;

	@Schema(description = "일차")
	private int day;

	@Schema(description = "레벨")
	private ChallengeLevelType level;

	@Schema(description = "출석일")
	private List<LocalDate> attendances;

	public static ChallengeProgressResponse of(Member member, Challenge challenge,
		int day, List<Attendance> attendances) {
		return ChallengeProgressResponse.builder()
			.babyNickname(member.getOnboarding().getBabyNickname())
			.day(day)
			.level(challenge.getLevel())
			.attendances(attendances
				.stream()
				.map(attendance -> LocalDate.from(attendance.getCreatedAt()))
				.collect(Collectors.toList()))
			.build();
	}
}
