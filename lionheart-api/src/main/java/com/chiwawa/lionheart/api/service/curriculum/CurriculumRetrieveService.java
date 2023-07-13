package com.chiwawa.lionheart.api.service.curriculum;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.service.curriculum.dto.response.CurriculumProgressResponse;
import com.chiwawa.lionheart.api.service.member.MemberServiceUtils;
import com.chiwawa.lionheart.common.dto.WeekAndDay;
import com.chiwawa.lionheart.common.util.DateUtils;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CurriculumRetrieveService {

	private final MemberRepository memberRepository;

	public CurriculumProgressResponse getCurriculumProgress(Long memberId) {
		Member member = MemberServiceUtils.findMemberById(memberRepository, memberId);
		LocalDate startDay = LocalDate.from(member.getCreatedAt());
		short startWeek = member.getOnboarding().getPregnantWeeks();
		WeekAndDay weekAndDay = DateUtils.getWeekAndDay(startWeek, startDay);

		int progress = 100; // TODO: 2023/07/12 progress 일별/월별 확정나면 로직 수정하기
		return CurriculumProgressResponse.of(member, weekAndDay, progress);
	}
}
