package com.example.envers.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@Configuration(proxyBeanMethods = false)
public class JpaConfig {

    @Bean
    public AuditorAware<UUID> auditorAware() {
        return () -> Optional.of(UUID.randomUUID());
    }

}
