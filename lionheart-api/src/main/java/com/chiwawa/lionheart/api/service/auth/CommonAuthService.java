package com.chiwawa.lionheart.api.service.auth;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.member.MemberServiceUtils;
import com.chiwawa.lionheart.common.util.JwtUtils;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class CommonAuthService {

	private final MemberRepository memberRepository;

	private final JwtUtils jwtUtils;

	public void logout(Long memberId) {
		Member member = MemberServiceUtils.findMemberById(memberRepository, memberId);
		jwtUtils.expireRefreshToken(member.getId());
	}
}
