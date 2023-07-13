package com.chiwawa.lionheart.domain.domain.challenge.repository;

import static com.chiwawa.lionheart.domain.domain.challenge.QAttendance.*;

import java.util.List;

import com.chiwawa.lionheart.domain.domain.challenge.Attendance;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AttendanceRepositoryImpl implements AttendanceRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<Attendance> findAttendancesByMember(Member member) {
		return queryFactory.selectFrom(attendance)
			.where(attendance.member.eq(member))
			.orderBy(attendance.createdAt.asc())
			.fetch();
	}
}
