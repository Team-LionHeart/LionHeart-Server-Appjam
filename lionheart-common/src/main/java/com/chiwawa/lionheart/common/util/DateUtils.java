package com.chiwawa.lionheart.common.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

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

	public static short getDay(LocalDate startDay) {
		short passedDay = DateUtils.getDayDifference(today(), startDay);

		return (short)(passedDay + 1);
	}

	public static String formatToChallengeDate(LocalDateTime date) {
		return String.format("%s/%s", date.getMonth().getValue(), date.getDayOfMonth());
	}
}
