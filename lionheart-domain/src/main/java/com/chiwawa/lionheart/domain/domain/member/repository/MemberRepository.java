package com.chiwawa.lionheart.domain.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
