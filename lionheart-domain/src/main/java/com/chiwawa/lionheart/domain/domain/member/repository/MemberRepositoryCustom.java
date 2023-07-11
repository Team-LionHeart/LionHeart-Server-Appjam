package com.chiwawa.lionheart.domain.domain.member.repository;

import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;

import java.util.Optional;

public interface MemberRepositoryCustom {

	boolean existsBySocialIdAndSocialType(String socialId, MemberSocialType socialType);

	Optional<Member> findMemberById(Long id);

	Optional<Member> findMemberBySocialIdAndSocialType(String socialId, MemberSocialType socialType);
}
