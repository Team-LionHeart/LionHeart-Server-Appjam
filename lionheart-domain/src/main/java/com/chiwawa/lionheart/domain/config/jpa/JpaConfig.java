package com.chiwawa.lionheart.domain.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.chiwawa.lionheart.domain.LionHeartDomainRoot;

@Configuration
@EntityScan(basePackageClasses = {LionHeartDomainRoot.class})
@EnableJpaRepositories(basePackageClasses = {LionHeartDomainRoot.class})
@EnableJpaAuditing
public class JpaConfig {

}
