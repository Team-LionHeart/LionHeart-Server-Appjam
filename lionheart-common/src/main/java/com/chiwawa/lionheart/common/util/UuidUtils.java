package com.chiwawa.lionheart.common.util;

import static com.chiwawa.lionheart.common.util.MessageUtils.*;

import java.util.UUID;

import lombok.Getter;

@Getter
public class UuidUtils {

	private static final String VERSION = "v1";
	private static final String UUID_FORMAT = "%s-%s";

	public static String generate() {
		return generateString(UUID_FORMAT, VERSION, UUID.randomUUID());
	}
}
