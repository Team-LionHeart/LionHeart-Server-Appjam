package com.chiwawa.lionheart.api.service.challenge;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.member.MemberServiceUtils;
import com.chiwawa.lionheart.common.dto.WeekAndDay;
import com.chiwawa.lionheart.common.util.DateUtils;
import com.chiwawa.lionheart.domain.domain.article.Article;
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

	private final static int ZERO = 0;

	public void checkAttendance(Article article, Member member) {
		if (isNotAttended(member)) {
			return;
		}

		WeekAndDay weekAndDay = MemberServiceUtils.findMemberWeekAndDay(member);
		boolean isTodayArticle = weekAndDay.equals(WeekAndDay.of(article.getWeek(), article.getDay()));

		if (isTodayArticle && validateLastAttendanceIsNotToday(member)) {
			challengeRepository.checkAttendance(member);

			int attendanceCount = attendanceRepository.findAttendancesByMember(member).size();
			member.getChallenge().levelUp(attendanceCount);
		}
	}

	private boolean validateLastAttendanceIsNotToday(Member member) {
		Attendance latestMemberAttendance = findMemberLastAttendance(member).get();
		int dayDifference = DateUtils.getDayDifference(LocalDateTime.now(), latestMemberAttendance.getCreatedAt());

		if (dayDifference == ZERO) {
			return true;
		}
		return false;
	}

	private boolean isNotAttended(Member member) {
		Optional<Attendance> firstMemberAttendance = findMemberLastAttendance(member);
		if (firstMemberAttendance.isEmpty()) {
			return true;
		}

		return DateUtils.getDayDifference(LocalDateTime.now(), firstMemberAttendance.get().getCreatedAt()) != ZERO;
	}

	private Optional<Attendance> findMemberLastAttendance(Member member) {
		List<Attendance> memberAttendances = attendanceRepository.findAttendancesByMember(member);
		return memberAttendances.stream().max(Comparator.comparing(Attendance::getCreatedAt));
	}
}
