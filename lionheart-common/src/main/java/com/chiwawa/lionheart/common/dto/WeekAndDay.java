package com.chiwawa.lionheart.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class WeekAndDay {

	private short week;
	private short day;

	public static WeekAndDay of(short week, short day) {
		return WeekAndDay.builder()
			.week(week)
			.day(day)
			.build();
	}
}
