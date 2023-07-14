package com.chiwawa.lionheart.api.service.challenge;

import static com.chiwawa.lionheart.common.constant.message.AttendanceErrorMessage.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.common.exception.ErrorCode;
import com.chiwawa.lionheart.common.exception.model.NotFoundException;
import com.chiwawa.lionheart.common.util.DateUtils;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.domain.domain.challenge.Attendance;
import com.chiwawa.lionheart.domain.domain.challenge.repository.AttendanceRepository;
import com.chiwawa.lionheart.domain.domain.challenge.repository.ChallengeRepository;
import com.chiwawa.lionheart.domain.domain.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ChallengeService {
	private final ChallengeRepository challengeRepository;
	private final AttendanceRepository attendanceRepository;

	private final static int ATTENDANCE = 0;

	public void checkAttendance(Member member) {
		if (compareLastAttendanceDate(member) != ATTENDANCE) {
			challengeRepository.checkAttendance(member);
		}
	}

	private int compareLastAttendanceDate(Member member) {
		Attendance firstMemberAttendance = findMemberLastAttendance(member);

		return DateUtils.getDayDifference(LocalDateTime.now(), firstMemberAttendance.getCreatedAt());
	}

	private Attendance findMemberLastAttendance(Member member) {
		List<Attendance> memberAttendances = attendanceRepository.findAttendancesByMember(member);

		return memberAttendances.stream().max(Comparator.comparing(Attendance::getCreatedAt))
			.orElseThrow(() ->
				new NotFoundException(
					MessageUtils.generate(NOT_EXIST_MEMBER_ATTENDANCE_DATA_ERROR_MESSAGE, member.getId()),
					ErrorCode.NOT_FOUND_MEMBER_ATTENDANCE_DATA_EXCEPTION));
	}
}
