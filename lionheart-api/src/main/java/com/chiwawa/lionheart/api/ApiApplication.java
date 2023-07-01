package com.chiwawa.lionheart.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chiwawa.lionheart.common.LionHeartCommonRoot;
import com.chiwawa.lionheart.domain.LionHeartDomainRoot;
import com.chiwawa.lionheart.external.LionHeartExternalRoot;

@SpringBootApplication(scanBasePackageClasses = {
	LionHeartCommonRoot.class,
	LionHeartDomainRoot.class,
	LionHeartExternalRoot.class,
	ApiApplication.class
})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
