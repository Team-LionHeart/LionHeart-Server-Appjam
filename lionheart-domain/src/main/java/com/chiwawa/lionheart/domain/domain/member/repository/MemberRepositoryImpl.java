package com.chiwawa.lionheart.domain.domain.member.repository;

import static com.chiwawa.lionheart.domain.domain.member.QMember.*;

import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public boolean existsBySocialIdAndSocialType(String socialId, MemberSocialType socialType) {
        return Optional.ofNullable(queryFactory.selectOne()
                .from(member)
                .where(
                        member.socialInfo.socialId.eq(socialId),
                        member.socialInfo.socialType.eq(socialType)
                )
                .fetchFirst()).isPresent();
    }

    @Override
    public Optional<Member> findMemberById(Long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(member)
                .where(member.id.eq(id))
                .fetchOne());
    }

    @Override
    public Optional<Member> findMemberBySocialIdAndSocialType(String socialId, MemberSocialType socialType) {
        return Optional.ofNullable(queryFactory
                .selectFrom(member)
                .where(
                        member.socialInfo.socialId.eq(socialId),
                        member.socialInfo.socialType.eq(socialType)
                )
                .fetchOne());
    }
}
