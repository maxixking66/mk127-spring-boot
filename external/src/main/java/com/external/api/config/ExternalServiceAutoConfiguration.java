package com.external.api.config;

import com.external.api.service.ExternalService;
import com.external.api.service.ExternalServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ExternalServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ExternalService externalService() {
        return new ExternalServiceImpl();
    }
}
