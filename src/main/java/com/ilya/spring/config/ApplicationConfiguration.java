package com.ilya.spring.config;

import com.ilya.spring.database.UserRepository;
import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.pool.ConnectionPool;
import com.ilya.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
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
        @Bean("pool2")
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool2(@Value ("${db.username}") String username,
                                    @Value("${db.pool.size}") Integer poolSize) {
                return new ConnectionPool(username, poolSize);
        }
        @Bean("pool3")
        public ConnectionPool pool3() {
                return new ConnectionPool("test-pool", 25 );
        }

        @Bean
        public UserRepository userRepository2(@Qualifier("pool") ConnectionPool pool2){
                return new UserRepository(pool2);
        }
}