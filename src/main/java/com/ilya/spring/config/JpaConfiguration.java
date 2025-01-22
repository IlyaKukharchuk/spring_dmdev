package com.ilya.spring.config;

import com.ilya.spring.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {
    @PostConstruct
    void init(){
        log.info("Jpa configuration is enabled!");
    }
}
