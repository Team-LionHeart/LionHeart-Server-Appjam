package com.chiwawa.lionheart.api.service.challenge;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.common.util.DateUtils;
import com.chiwawa.lionheart.domain.domain.challenge.Attendance;
import com.chiwawa.lionheart.domain.domain.challenge.repository.AttendanceRepository;
import com.chiwawa.lionheart.domain.domain.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ChallengeService {
	private final AttendanceRepository attendanceRepository;

	public void checkAttendance(Member member) {
		if (notAttended(member)) {
			attendanceRepository.save(Attendance.newInstance(member));
		}
	}

	private boolean notAttended(Member member) {
		Optional<Attendance> firstMemberAttendance = findMemberLastAttendance(member);
		if (firstMemberAttendance.isEmpty()) {
			return true;
		}
		return DateUtils.getDayDifference(LocalDateTime.now(), firstMemberAttendance.get().getCreatedAt()) != 0;
	}

	private Optional<Attendance> findMemberLastAttendance(Member member) {
		List<Attendance> memberAttendances = attendanceRepository.findAttendancesByMember(member);
		return memberAttendances.stream().max(Comparator.comparing(Attendance::getCreatedAt));
	}
}
