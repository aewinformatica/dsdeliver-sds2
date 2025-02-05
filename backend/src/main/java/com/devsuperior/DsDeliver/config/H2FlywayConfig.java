package com.devsuperior.DsDeliver.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
@Import(FlywayAutoConfiguration.class)
public class H2FlywayConfig {

    @Bean
    @ConditionalOnMissingBean(name = "flyway")
    @ConditionalOnProperty(name = "spring.flyway.enabled", havingValue = "false")
    boolean flywayDisabled() {
        System.out.println("Flyway is disabled for H2 database.");
        return false;
    }
}