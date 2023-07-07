package com.chiwawa.lionheart.api.service.member;

import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import com.chiwawa.lionheart.common.exception.ConflictException;
import com.chiwawa.lionheart.common.exception.NotFoundException;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberServiceUtils {

	static void validateNotExistsMember(MemberRepository memberRepository, String socialId,
		MemberSocialType socialType) {
		if (memberRepository.existsBySocialIdAndSocialType(socialId, socialType)) {
			throw new ConflictException(String.format("이미 존재하는 유저 (%s - %s) 입니다", socialId, socialType),
				CONFLICT_USER_EXCEPTION);
		}
	}

	public static Member findMemberBySocialIdAndSocialType(MemberRepository memberRepository, String socialId,
		MemberSocialType socialType) {
		Member member = memberRepository.findMemberBySocialIdAndSocialType(socialId, socialType);
		if (member == null) {
			throw new NotFoundException(String.format("존재하지 않는 유저 (%s) (%s) 입니다", socialType, socialId),
				NOT_FOUND_USER_EXCEPTION);
		}
		return member;
	}

	public static Member findMemberById(MemberRepository userRepository, Long userId) {
		Member member = userRepository.findMemberById(userId);
		if (member == null) {
			throw new NotFoundException(String.format("존재하지 않는 유저 (%s) 입니다", userId), NOT_FOUND_USER_EXCEPTION);
		}
		return member;
	}

}
