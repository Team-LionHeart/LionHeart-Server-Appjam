package com.chiwawa.lionheart.domain.domain.member.repository;

import static com.chiwawa.lionheart.domain.domain.member.QOnboarding.*;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.Onboarding;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OnboardingRepositoryImpl implements OnboardingRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<Onboarding> findOnboardingByMember(Member member) {
		return Optional.ofNullable(queryFactory
			.selectFrom(onboarding)
			.where(onboarding.member.eq(member))
			.fetchOne());
	}
}
