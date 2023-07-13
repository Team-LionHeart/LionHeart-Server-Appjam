package com.chiwawa.lionheart.api.service.challenge;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.challenge.dto.response.ChallengeProgressResponse;
import com.chiwawa.lionheart.api.service.member.MemberServiceUtils;
import com.chiwawa.lionheart.common.util.DateUtils;
import com.chiwawa.lionheart.domain.domain.challenge.Attendance;
import com.chiwawa.lionheart.domain.domain.challenge.Challenge;
import com.chiwawa.lionheart.domain.domain.challenge.repository.AttendanceRepository;
import com.chiwawa.lionheart.domain.domain.challenge.repository.ChallengeRepository;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ChallengeRetrieveService {

	private final MemberRepository memberRepository;
	private final ChallengeRepository challengeRepository;
	private final AttendanceRepository attendanceRepository;

	public ChallengeProgressResponse getChallengeProgress(Long memberId) {
		Member member = MemberServiceUtils.findMemberById(memberRepository, memberId);
		Challenge challenge = ChallengeServiceUtils.findChallengeByMember(challengeRepository, member);
		List<Attendance> attendances = attendanceRepository.findAttendancesByMember(member);
		LocalDate today = DateUtils.today();
		LocalDate startDay = LocalDate.from(member.getCreatedAt());
		int passedDay = DateUtils.getDayDifference(today, startDay);
		return ChallengeProgressResponse.of(member, challenge, passedDay + 1, attendances);
	}
}
