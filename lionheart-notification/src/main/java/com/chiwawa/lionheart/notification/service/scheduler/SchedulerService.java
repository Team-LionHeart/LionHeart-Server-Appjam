package com.chiwawa.lionheart.notification.service.scheduler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.common.dto.WeekAndDay;
import com.chiwawa.lionheart.common.util.DateUtils;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;
import com.chiwawa.lionheart.domain.domain.notification.TodayArticleNotification;
import com.chiwawa.lionheart.domain.domain.notification.repository.TodayArticleNotificationRepository;
import com.chiwawa.lionheart.notification.service.firebase.FirebaseCloudMessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class SchedulerService {

	private final MemberRepository memberRepository;
	private final TodayArticleNotificationRepository todayArticleNotificationRepository;
	private final FirebaseCloudMessageService firebaseCloudMessageService;

	/**
	 * 매일 8시 0분 0초마다 실행
	 */
	@Scheduled(cron = "0  0  8  *  *  *")
	public void sendTodayArticleNotification() {
		List<Member> members = memberRepository.findAll();
		Map<WeekAndDay, TodayArticleNotification> notificationMap = getTodayArticleNotificationMap();
		members.forEach(member -> {
			short startWeek = member.getOnboarding().getPregnantWeeks();
			LocalDate startDay = LocalDate.from(member.getCreatedAt());
			WeekAndDay weekAndDay = DateUtils.getWeekAndDay(startWeek, startDay);
			TodayArticleNotification notification = notificationMap.get(weekAndDay);
			firebaseCloudMessageService.sendMessageTo(
				member.getFcmToken(), notification.getTitle(), notification.getBody());
		});
	}

	private Map<WeekAndDay, TodayArticleNotification> getTodayArticleNotificationMap() {
		Map<WeekAndDay, TodayArticleNotification> map = new HashMap<>();
		todayArticleNotificationRepository.findAll()
			.forEach(notification -> {
				WeekAndDay weekAndDay = WeekAndDay.of(notification.getWeek(), notification.getDay());
				map.put(weekAndDay, notification);
			});
		return map;
	}
}
