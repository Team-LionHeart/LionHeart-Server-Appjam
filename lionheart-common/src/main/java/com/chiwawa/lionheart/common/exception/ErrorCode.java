package com.chiwawa.lionheart.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

	// Validation Exception
	VALIDATION_EXCEPTION("V001", "잘못된 요청입니다."),
	METHOD_NOT_ALLOWED_EXCEPTION("V002", "지원하지 않는 메소드입니다."),
	UNSUPPORTED_MEDIA_TYPE("V003", "허용하지 않는 미디어 타입입니다."),
	VALIDATION_INVALID_TOKEN_EXCEPTION("V004", "잘못된 토큰입니다."),

	// Unauthorized Exception
	UNAUTHORIZED_EXCEPTION("U001", "토큰이 만료되었습니다. 다시 로그인 해주세요."),

	// Forbidden Exception
	FORBIDDEN_EXCEPTION("F001", "허용하지 않는 접근입니다."),

	// NotFound Exception
	NOT_FOUND_EXCEPTION("N001", "존재하지 않습니다."),
	NOT_FOUND_MEMBER_EXCEPTION("N002", "탈퇴했거나 존재하지 않는 회원입니다."),
	NOT_FOUND_ARTICLE_CONTENT_EXCEPTION("N003", "아티클의 컨텐츠가 존재하지 않습니다."),
	NOT_FOUND_CHALLENGE_EXCEPTION("N004", "존재하지 않는 챌린지입니다."),
	NOT_FOUND_ARTICLE_EXCEPTION("N005", "삭제되었거나 존재하지 않는 아티클입니다."),

	NOT_FOUND_ARTICLE_IN_WEEK_AND_DAY_EXCEPTION("N006", "해당 주차 일차에 해당하는 아티클이 존재하지 않습니다."),

	// Conflict Exception
	CONFLICT_EXCEPTION("C001", "이미 존재합니다."),
	CONFLICT_MEMBER_EXCEPTION("C002", "이미 해당 계정으로 회원가입하셨습니다.\n로그인 해주세요."),
	CONFLICT_BOOKMARK_EXCEPTION("C003", "요청과 동일한 북마크 상태 입니다."),

	// Unsupported Media Type Exception

	// Internal Server Exception
	INTERNAL_SERVER_EXCEPTION("I001", "서버 내부에서 에러가 발생하였습니다."),

	// Bad Gateway Exception
	BAD_GATEWAY_EXCEPTION("B001", "외부 연동 중 에러가 발생하였습니다.");

	private final String code;
	private final String message;

}
