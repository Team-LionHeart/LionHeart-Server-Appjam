package com.chiwawa.lionheart.api.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.member.dto.request.CreateMemberRequestDto;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public Long registerMember(CreateMemberRequestDto request) {
		MemberServiceUtils.validateNotExistsMember(memberRepository, request.getSocialId(), request.getSocialType());
		Member member = memberRepository.save(
			Member.newInstance(request.getSocialId(), request.getSocialType()));
		return member.getId();
	}

}
