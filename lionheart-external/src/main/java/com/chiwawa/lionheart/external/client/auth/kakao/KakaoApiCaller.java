package com.chiwawa.lionheart.external.client.auth.kakao;

import com.chiwawa.lionheart.external.client.auth.kakao.dto.response.KakaoProfileResponse;

public interface KakaoApiCaller {

	KakaoProfileResponse getProfileInfo(String accessToken);

}
