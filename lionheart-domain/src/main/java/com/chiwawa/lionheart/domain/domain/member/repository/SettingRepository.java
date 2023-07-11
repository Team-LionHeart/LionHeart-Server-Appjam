package com.chiwawa.lionheart.domain.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiwawa.lionheart.domain.domain.member.Setting;

public interface SettingRepository extends JpaRepository<Setting, Long>, SettingRepositoryCustom {
}