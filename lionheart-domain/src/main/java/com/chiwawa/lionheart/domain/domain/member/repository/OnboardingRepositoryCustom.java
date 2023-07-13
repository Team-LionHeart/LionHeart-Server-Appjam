package com.chiwawa.lionheart.domain.domain.member.repository;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.Onboarding;

public interface OnboardingRepositoryCustom {

	Optional<Onboarding> findOnboardingByMember(Member member);

}