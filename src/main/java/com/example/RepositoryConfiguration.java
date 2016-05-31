package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example")
@EntityScan(basePackages = {"com.example.entity"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
@EnableTransactionManagement
@EnableJpaAuditing()
public class RepositoryConfiguration {
    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }
}
