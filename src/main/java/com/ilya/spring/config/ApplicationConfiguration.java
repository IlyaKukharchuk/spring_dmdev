package com.ilya.spring.config;

import com.ilya.spring.database.abstractioins.CrudRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.ilya.spring",
        useDefaultFilters = false,
        includeFilters = {
            @Filter(type = FilterType.ANNOTATION, value = Component.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
            @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
        })      // чтобы анноташки @Component, @Service и т.д. работали
public class ApplicationConfiguration {

}