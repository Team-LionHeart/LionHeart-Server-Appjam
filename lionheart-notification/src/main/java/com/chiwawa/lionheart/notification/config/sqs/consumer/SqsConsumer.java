package com.chiwawa.lionheart.notification.config.sqs.consumer;

import java.util.Map;

import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.chiwawa.lionheart.common.constant.MessageType;
import com.chiwawa.lionheart.common.util.MessageUtils;
import com.chiwawa.lionheart.notification.config.sqs.dto.FirebaseDto;
import com.chiwawa.lionheart.notification.service.firebase.FirebaseCloudMessageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SqsConsumer {

	private final ObjectMapper objectMapper;
	private final FirebaseCloudMessageService firebaseCloudMessageService;
	private static final String SQS_CONSUME_LOG_MESSAGE =
		"====> [SQS Queue Response]\n" + "info: %s\n" + "header: %s\n";

	@SqsListener(value = "${cloud.aws.sqs.notification.name}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
	public void consume(@Payload String info, @Headers Map<String, String> headers, Acknowledgment ack) {
		try {
			log.info(MessageUtils.generate(SQS_CONSUME_LOG_MESSAGE, info, headers));
			switch (headers.get(MessageType.MESSAGE_TYPE_HEADER)) {
				case MessageType.FIREBASE:
					FirebaseDto firebaseDto = objectMapper.readValue(info, FirebaseDto.class);
					firebaseCloudMessageService.sendMessageTo(
						firebaseDto.getFcmToken(), firebaseDto.getTitle(), firebaseDto.getBody());
					break;
			}
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
		}
		ack.acknowledge();
	}
}
