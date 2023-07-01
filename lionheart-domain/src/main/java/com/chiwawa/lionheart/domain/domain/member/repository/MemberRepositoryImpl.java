package com.chiwawa.lionheart.domain.domain.member.repository;

import static com.chiwawa.lionheart.domain.domain.member.QMember.*;

import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public boolean existsBySocialIdAndSocialType(String socialId, MemberSocialType socialType) {
		return queryFactory.selectOne()
			.from(member)
			.where(
				member.socialInfo.socialId.eq(socialId),
				member.socialInfo.socialType.eq(socialType)
			)
			.fetchFirst() != null;
	}

	@Override
	public Member findMemberById(Long id) {
		return queryFactory
			.selectFrom(member)
			.where(member.id.eq(id))
			.fetchOne();
	}

	@Override
	public Member findMemberBySocialIdAndSocialType(String socialId, MemberSocialType socialType) {
		return queryFactory
			.selectFrom(member)
			.where(
				member.socialInfo.socialId.eq(socialId),
				member.socialInfo.socialType.eq(socialType)
			)
			.fetchOne();
	}
}
