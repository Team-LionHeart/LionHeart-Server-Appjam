package com.chiwawa.lionheart.api.service.challenge;

import static com.chiwawa.lionheart.common.constant.message.ChallengeErrorMessage.*;
import static com.chiwawa.lionheart.common.exception.ErrorCode.*;

import java.util.Optional;

import com.chiwawa.lionheart.common.exception.model.NotFoundException;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.challenge.Challenge;
import com.chiwawa.lionheart.domain.domain.challenge.repository.ChallengeRepository;
import com.chiwawa.lionheart.domain.domain.member.Member;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChallengeServiceUtils {

	public static Challenge findChallengeByMember(ChallengeRepository challengeRepository, Member member) {
		Optional<Challenge> challenge = challengeRepository.findChallengeByMember(member);
		return challenge.orElseThrow(() -> new NotFoundException(
			MessageUtils.generate(NOT_EXIST_CHALLENGE_MEMBER_ID_ERROR_MESSAGE, member.getId()),
			NOT_FOUND_CHALLENGE_EXCEPTION));
	}

}
