package com.chiwawa.lionheart.common.util;

import java.util.UUID;

import lombok.Getter;

@Getter
public class UuidUtils {

	private static final String VERSION = "v1";
	private static final String UUID_FORMAT = "%s-%s";

	public static String generate() {
		return MessageUtils.generate(UUID_FORMAT, VERSION, UUID.randomUUID());
	}
}
