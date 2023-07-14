package com.chiwawa.lionheart.api.controller.notification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiwawa.lionheart.api.controller.notification.dto.request.CustomNotificationRequest;
import com.chiwawa.lionheart.api.service.notification.NotificationService;
import com.chiwawa.lionheart.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Notification")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class NotificationController {

	private final NotificationService notificationService;

	// TODO: 2023/07/14 관리자만 실행할 수 있도록 @Admin 어노테이션 추가하기
	@Operation(summary = "[관리자] 모든 회원에게 커스텀 푸시 알림 전송")
	@PostMapping("/notification/all")
	public ApiResponse<String> sendCustomNotificationToAllMember(@RequestBody CustomNotificationRequest request) {
		notificationService.sendCustomNotificationToAllMember(request);
		return ApiResponse.SUCCESS;
	}
}