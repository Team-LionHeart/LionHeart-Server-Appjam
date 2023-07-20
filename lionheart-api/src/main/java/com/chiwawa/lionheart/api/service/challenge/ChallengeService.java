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
import com.chiwawa.lionheart.domain.domain.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ChallengeService {
	private final AttendanceRepository attendanceRepository;

	private final static int ZERO = 0;


	public void checkAttendance(Article article, Member member) {
		if (isNotAttended(member)) {
			if (isTodayArticle(article, member)) {
				attendanceRepository.save(Attendance.newInstance(member));

				int attendanceCheckCount = attendanceRepository.findAttendancesByMember(member).size();
				member.getChallenge().levelUp(attendanceCheckCount);
			}
		}
	}

	private boolean isTodayArticle(Article article, Member member) {
		WeekAndDay weekAndDay = MemberServiceUtils.findMemberWeekAndDay(member);

		return weekAndDay.equals(WeekAndDay.of(article.getWeek(), article.getDay()));
	}

	private boolean isNotAttended(Member member) {
		Optional<Attendance> memberLatestAttendance = findMemberLastAttendance(member);
		if (memberLatestAttendance.isEmpty()) {
			return true;
		}

		return DateUtils.getDayDifference(LocalDateTime.now(), memberLatestAttendance.get().getCreatedAt()) != ZERO;
	}

	private Optional<Attendance> findMemberLastAttendance(Member member) {
		List<Attendance> memberAttendances = attendanceRepository.findAttendancesByMember(member);
		return memberAttendances.stream().max(Comparator.comparing(Attendance::getCreatedAt));
	}
}

