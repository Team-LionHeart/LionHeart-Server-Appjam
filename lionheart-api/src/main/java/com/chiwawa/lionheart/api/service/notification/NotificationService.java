package com.chiwawa.lionheart.api.service.notification;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chiwawa.lionheart.api.config.sqs.producer.SqsProducer;
import com.chiwawa.lionheart.api.controller.notification.dto.request.CustomNotificationRequest;
import com.chiwawa.lionheart.api.controller.notification.dto.request.SlackNotificationRequest;
import com.chiwawa.lionheart.common.dto.sqs.FirebaseDto;
import com.chiwawa.lionheart.common.dto.sqs.SlackDto;
import com.chiwawa.lionheart.domain.domain.member.Member;
import com.chiwawa.lionheart.domain.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class NotificationService {

	private final MemberRepository memberRepository;
	private final SqsProducer sqsProducer;

	public void sendCustomNotificationToAllMember(CustomNotificationRequest request) {
		List<Member> members = memberRepository.findAll();
		members.forEach(member -> {
			sqsProducer.produce(FirebaseDto.of(member.getFcmToken(), request.getTitle(), request.getBody()));
		});
	}

	public void sendCustomNotificationToSlack(SlackNotificationRequest request) {
		sqsProducer.produce(SlackDto.of(request.getError(), request.getRequestMethod(), request.getRequestUri()));
	}

}

