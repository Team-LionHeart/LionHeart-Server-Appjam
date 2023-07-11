package com.chiwawa.lionheart.common.constant.message;

public class AuthErrorMessage {

	// JWT Error Message
	public static String WRONG_JWT_ERROR_MESSAGE = "잘못된 JWT (%s) 입니다.";
	public static String INVALID_JWT_REFRESH_TOKEN_ERROR_MESSAGE = "주어진 리프레시 토큰 (%s) 이 유효하지 않습니다.";
	public static String EXPIRED_JWT_REFRESH_TOKEN_ERROR_MESSAGE = "이미 만료된 리프레시 토큰 (%s) 입니다.";
	public static String WRONG_JWT_REFRESH_TOKEN_ERROR_MESSAGE = "해당 리프레시 토큰 (%s) 의 정보가 일치하지 않습니다.";
	public static String INVALID_JWT_TOKEN_ERROR_MESSAGE = "Invalid JWT Token";
	public static String EXPIRED_JWT_TOKEN_ERROR_MESSAGE = "Expired JWT Token";
	public static String UNSUPPORTED_JWT_TOKEN_ERROR_MESSAGE = "Unsupported JWT Token";
	public static String EMPTY_CLAIMS_JWT_TOKEN_ERROR_MESSAGE = "JWT claims string is empty.";
	public static String UNHANDLED_JWT_TOKEN_ERROR_MESSAGE = "Unhandled JWT exception";

	// Member Auth Error Message
	public static String NEED_AUTH_ANNOTATION_ERROR_MESSAGE = "인증이 필요한 컨트롤러 입니다. @Auth 어노테이션을 붙여주세요.";
	public static String CAN_NOT_GET_MEMBER_ID_ERROR_MESSAGE = "MEMBER_ID를 가져오지 못했습니다. (%s - %s)";

	// Kakao Auth Error Message
	public static String WRONG_KAKAO_ACCESS_TOKEN_ERROR_MESSAGE = "잘못된 카카오 액세스 토큰 (%s) 입니다.";
	public static String KAKAO_LOGIN_ERROR_MESSAGE = "카카오 로그인 연동 중 에러가 발생하였습니다.";

}
