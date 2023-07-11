package com.chiwawa.lionheart.api.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.member.dto.response.ProfileResponse;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberRetrieveService {

	private final MemberRepository memberRepository;

	public ProfileResponse getProfile(Long memberId) {
		Member member = MemberServiceUtils.findMemberById(memberRepository, memberId);
		return ProfileResponse.of(member);
	}
}
