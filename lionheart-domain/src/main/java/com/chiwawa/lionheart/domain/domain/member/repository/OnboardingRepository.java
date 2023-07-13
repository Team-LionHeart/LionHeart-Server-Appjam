package com.chiwawa.lionheart.domain.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.member.Onboarding;

public interface OnboardingRepository extends JpaRepository<Onboarding, Long>, OnboardingRepositoryCustom {
}
