package com.chiwawa.lionheart.domain.domain.challenge.repository;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.challenge.Challenge;
import com.chiwawa.lionheart.domain.domain.member.Member;

public interface ChallengeRepositoryCustom {

	Optional<Challenge> findChallengeByMember(Member member);
}
