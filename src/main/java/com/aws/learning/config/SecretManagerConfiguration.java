package com.aws.learning.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretManagerConfiguration {
    @Value("${api-key1}")
    private  String apiKeyValue1;

    @Value("${api-key2}")
    private  String apiKeyValue2;

    @PostConstruct
    private void postConstruct() {
        System.out.println(apiKeyValue1);
        System.out.println(apiKeyValue2);
    }

}
