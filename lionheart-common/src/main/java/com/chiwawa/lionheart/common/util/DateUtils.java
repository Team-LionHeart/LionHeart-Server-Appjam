package com.chiwawa.lionheart.common.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.chiwawa.lionheart.common.dto.WeekAndDay;

public class DateUtils {

	private static final String ASIA_SEOUL = "Asia/Seoul";

	public static LocalDate today() {
		return LocalDate.now(ZoneId.of(ASIA_SEOUL));
	}

	public static LocalDateTime now() {
		return LocalDateTime.now(ZoneId.of(ASIA_SEOUL));
	}

	public static short getDayDifference(LocalDate date1, LocalDate date2) {
		LocalDateTime localDateTime1 = date1.atStartOfDay();
		LocalDateTime localDateTime2 = date2.atStartOfDay();
		return (short)Math.abs(Duration.between(localDateTime1, localDateTime2).toDays());
	}

	public static int getDayDifference(LocalDateTime date1, LocalDate date2) {
		LocalDateTime localDateTime1 = LocalDate.from(date1).atStartOfDay();
		LocalDateTime localDateTime2 = date2.atStartOfDay();
		return (int)Math.abs(Duration.between(localDateTime1, localDateTime2).toDays());
	}

	public static int getDayDifference(LocalDateTime date1, LocalDateTime date2) {
		LocalDateTime localDateTime1 = LocalDate.from(date1).atStartOfDay();
		LocalDateTime localDateTime2 = LocalDate.from(date2).atStartOfDay();
		return (int)Math.abs(Duration.between(localDateTime1, localDateTime2).toDays());
	}

	public static WeekAndDay getWeekAndDay(short startWeek, LocalDate startDay) {
		short passedDay = DateUtils.getDayDifference(today(), startDay);
		short week = (short)(startWeek + passedDay / 7);
		short day = (short)(1 + passedDay % 7);

		return WeekAndDay.of(week, day);
	}

	public static int getRemainingDay(WeekAndDay nowWeekAndDay) {
		int totalDay = 40 * 7 + 7;
		int passedDay = nowWeekAndDay.getWeek() * 7 + nowWeekAndDay.getDay();
		return totalDay - passedDay;
	}

	public static short getDay(LocalDate startDay) {
		short passedDay = DateUtils.getDayDifference(today(), startDay);

		return (short)(passedDay + 1);
	}

	public static int getPassedMonth(int week) {
		List<List<Integer>> monthRanges = List.of(
			List.of(4, 5, 6, 7),         // 2개월
			List.of(8, 9, 10, 11),       // 3개월
			List.of(12, 13, 14, 15),     // 4개월
			List.of(16, 17, 18, 19),     // 5개월
			List.of(20, 21, 22, 23),     // 6개월
			List.of(24, 25, 26, 27),     // 7개월
			List.of(28, 29, 30, 31),     // 8개월
			List.of(32, 33, 34, 35),     // 9개월
			List.of(36, 37, 38, 39, 40)  // 10개월
		);
		for (int i = 0; i < monthRanges.size(); i++) {
			if (monthRanges.get(i).contains(week)) {
				return i + 2;
			}
		}
		return 1;
	}

	public static String formatToChallengeDate(LocalDateTime date) {
		return String.format("%s/%s", date.getMonth().getValue(), date.getDayOfMonth());
	}
}
