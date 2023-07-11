package com.chiwawa.lionheart.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chiwawa.lionheart.common.LionHeartCommonRoot;
import com.chiwawa.lionheart.domain.LionHeartDomainRoot;
import com.chiwawa.lionheart.external.LionHeartExternalRoot;

@SpringBootApplication(scanBasePackageClasses = {
	LionHeartCommonRoot.class,
	LionHeartDomainRoot.class,
	LionHeartExternalRoot.class,
	NotificationApplication.class
})
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

}
