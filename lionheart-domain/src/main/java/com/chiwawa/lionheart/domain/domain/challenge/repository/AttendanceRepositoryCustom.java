package com.chiwawa.lionheart.domain.domain.challenge.repository;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.challenge.Attendance;
import com.chiwawa.lionheart.domain.domain.member.Member;

public interface AttendanceRepositoryCustom {

	List<Attendance> findAttendancesByMember(Member member);
}
