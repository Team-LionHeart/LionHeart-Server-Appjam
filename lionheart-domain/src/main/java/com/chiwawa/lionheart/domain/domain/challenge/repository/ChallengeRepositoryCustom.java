package com.chiwawa.lionheart.domain.domain.challenge.repository;

import com.chiwawa.lionheart.domain.domain.challenge.Challenge;

public interface ChallengeRepositoryCustom {

	Challenge findChallengeById(Long id);
}