package com.chiwawa.lionheart.api.service.member;

import static com.chiwawa.lionheart.common.constant.message.MemberErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import java.util.Optional;

import com.chiwawa.lionheart.common.exception.model.ConflictException;
import com.chiwawa.lionheart.common.exception.model.NotFoundException;
import com.chiwawa.lionheart.common.util.MessageUtils;
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
			throw new ConflictException(
				MessageUtils.generate(ALREADY_EXIST_MEMBER_ERROR_MESSAGE, socialId, socialType),
				CONFLICT_MEMBER_EXCEPTION);
		}
	}

	public static Member findMemberBySocialIdAndSocialType(MemberRepository memberRepository, String socialId,
		MemberSocialType socialType) {
		Optional<Member> member = memberRepository.findMemberBySocialIdAndSocialType(socialId, socialType);
		return member.orElseThrow(() -> new NotFoundException(
			MessageUtils.generate(NOT_EXIST_MEMBER_SOCIAL_DATA_ERROR_MESSAGE, socialType, socialId),
			NOT_FOUND_MEMBER_EXCEPTION));
	}

	public static Member findMemberById(MemberRepository memberRepository, Long memberId) {
		Optional<Member> member = memberRepository.findMemberById(memberId);
		return member.orElseThrow(() ->
			new NotFoundException(MessageUtils.generate(NOT_EXIST_MEMBER_ID_ERROR_MESSAGE, memberId),
				NOT_FOUND_MEMBER_EXCEPTION));

	}

}
