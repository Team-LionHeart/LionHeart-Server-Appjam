package com.chiwawa.lionheart.api.service.curriculum.dto.response;

import com.chiwawa.lionheart.common.dto.WeekAndDay;
import com.chiwawa.lionheart.common.util.DateUtils;

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
public class CurriculumProgressResponse {

	@Schema(description = "주차")
	private int week;

	@Schema(description = "일차")
	private int day;

	@Schema(description = "진척도")
	private int progress;

	@Schema(description = "D-Day")
	private int remainingDay;

	public static CurriculumProgressResponse of(WeekAndDay weekAndDay, int progress) {
		return CurriculumProgressResponse.builder()
			.week(weekAndDay.getWeek())
			.day(weekAndDay.getDay())
			.remainingDay(DateUtils.getRemainingDay(weekAndDay))
			.progress(progress)
			.build();
	}
}
