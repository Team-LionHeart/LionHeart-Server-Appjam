package com.chiwawa.lionheart.common.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtils {

	private static final String ASIA_SEOUL = "Asia/Seoul";

	public static LocalDate today() {
		return LocalDate.now(ZoneId.of(ASIA_SEOUL));
	}

	public static LocalDateTime now() {
		return LocalDateTime.now(ZoneId.of(ASIA_SEOUL));
	}

	public static int getDayDifference(LocalDate date1, LocalDate date2) {
		LocalDateTime localDateTime1 = date1.atStartOfDay();
		LocalDateTime localDateTime2 = date2.atStartOfDay();
		return (int)Math.abs(Duration.between(localDateTime1, localDateTime2).toDays());
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
}
