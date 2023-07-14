package com.chiwawa.lionheart.domain.domain.challenge.repository;

import static com.chiwawa.lionheart.domain.domain.challenge.QChallenge.*;

import java.util.Optional;

import com.chiwawa.lionheart.domain.domain.challenge.Challenge;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChallengeRepositoryImpl implements ChallengeRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<Challenge> findChallengeByMember(Member member) {
		return Optional.ofNullable(queryFactory
			.selectFrom(challenge)
			.where(challenge.member.eq(member))
			.fetchOne());
	}

	@Override
	public void checkAttendance(Member member) {
		queryFactory
			.insert(challenge)
			.columns(challenge.member)
			.values(member).execute();

	}
}
