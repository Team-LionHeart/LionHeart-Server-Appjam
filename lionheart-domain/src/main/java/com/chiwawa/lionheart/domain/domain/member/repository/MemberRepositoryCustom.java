package com.chiwawa.lionheart.domain.domain.member.repository;

import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.MemberSocialType;

public interface MemberRepositoryCustom {

	boolean existsBySocialIdAndSocialType(String socialId, MemberSocialType socialType);

	Member findMemberById(Long id);

	Member findMemberBySocialIdAndSocialType(String socialId, MemberSocialType socialType);
}
