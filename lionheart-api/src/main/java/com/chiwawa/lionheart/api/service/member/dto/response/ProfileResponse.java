package com.chiwawa.lionheart.api.service.member.dto.response;

import com.chiwawa.lionheart.domain.domain.challenge.ChallengeLevelType;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.NotificationStatus;

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
public class ProfileResponse {

	@Schema(description = "태명")
	private String babyNickname;

	@Schema(description = "레벨")
	private ChallengeLevelType level;

	@Schema(description = "알림 상태 - ON / OFF")
	private NotificationStatus notificationStatus;

	public static ProfileResponse of(Member member) {
		return ProfileResponse.builder()
			.babyNickname(member.getOnboarding().getBabyNickname())
			.level(member.getChallenge().getLevel())
			.notificationStatus(member.getSetting().getNotificationStatus())
			.build();
	}
}
