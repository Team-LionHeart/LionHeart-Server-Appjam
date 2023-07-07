package com.chiwawa.lionheart.api.service.auth;

import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.auth.dto.request.TokenRequest;
import com.chiwawa.lionheart.api.service.auth.dto.response.TokenResponse;
import com.chiwawa.lionheart.api.service.member.MemberServiceUtils;
import com.chiwawa.lionheart.common.constant.RedisKey;
import com.chiwawa.lionheart.common.exception.UnAuthorizedException;
import com.chiwawa.lionheart.common.util.JwtUtils;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class CreateTokenService {

	private final MemberRepository memberRepository;

	private final RedisTemplate redisTemplate;

	private final JwtUtils jwtUtils;

	public TokenResponse createTokenInfo(Long memberId) {
		List<String> tokens = jwtUtils.createTokenInfo(memberId);
		return TokenResponse.of(tokens.get(0), tokens.get(1));
	}

	public TokenResponse reissueToken(TokenRequest request) {
		Long memberId = jwtUtils.getMemberIdFromJwt(request.getAccessToken());
		Member member = MemberServiceUtils.findMemberById(memberRepository, memberId);
		if (!jwtUtils.validateToken(request.getRefreshToken())) {
			throw new UnAuthorizedException(String.format("주어진 리프레시 토큰 (%s) 이 유효하지 않습니다.", request.getRefreshToken()));
		}
		String refreshToken = (String)redisTemplate.opsForValue().get(RedisKey.REFRESH_TOKEN + memberId);
		if (Objects.isNull(refreshToken)) {
			throw new UnAuthorizedException(String.format("이미 만료된 리프레시 토큰 (%s) 입니다.", request.getRefreshToken()));
		}
		if (!refreshToken.equals(request.getRefreshToken())) {
			jwtUtils.expireRefreshToken(member.getId());
			throw new UnAuthorizedException(
				String.format("해당 리프레시 토큰 (%s) 의 정보가 일치하지 않습니다.", request.getRefreshToken()));
		}
		List<String> tokens = jwtUtils.createTokenInfo(memberId);
		return TokenResponse.of(tokens.get(0), tokens.get(1));
	}
}
