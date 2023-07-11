package com.chiwawa.lionheart.api.service.member;

import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import com.chiwawa.lionheart.common.exception.ConflictException;
import com.chiwawa.lionheart.common.exception.NotFoundException;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberServiceUtils {

	static void validateNotExistsMember(MemberRepository memberRepository, String socialId,
		MemberSocialType socialType) {
		if (memberRepository.existsBySocialIdAndSocialType(socialId, socialType)) {
			throw new ConflictException(String.format("이미 존재하는 회원 (%s - %s) 입니다", socialId, socialType),
				CONFLICT_MEMBER_EXCEPTION);
		}
	}

	public static Member findMemberBySocialIdAndSocialType(MemberRepository memberRepository, String socialId,
		MemberSocialType socialType) {
		Optional<Member> member = memberRepository.findMemberBySocialIdAndSocialType(socialId, socialType);
		return member.orElseThrow(() -> new NotFoundException(String.format("존재하지 않는 회원 (%s) (%s) 입니다", socialType, socialId),
				NOT_FOUND_MEMBER_EXCEPTION));
	}

	public static Member findMemberById(MemberRepository memberRepository, Long memberId) {
		Optional<Member> member = memberRepository.findMemberById(memberId);
		return member.orElseThrow(() ->
				new NotFoundException(String.format("존재하지 않는 회원 (%s) 입니다", memberId), NOT_FOUND_MEMBER_EXCEPTION));

	}

}
