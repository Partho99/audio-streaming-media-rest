package com.audio.stream.media.audiostreamingmedia.configuration;

import com.audio.stream.media.audiostreamingmedia.AuditorAwareBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.audio.stream.media.audiostreamingmedia.repository")
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig {
    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareBean();
    }
}
