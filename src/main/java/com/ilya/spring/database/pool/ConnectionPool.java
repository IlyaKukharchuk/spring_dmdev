package com.ilya.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component("pool")
public class ConnectionPool{

    private final String username;

    private final Integer poolSize;

    public ConnectionPool(@Value("${db.username}") String username, @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        log.info("Init connection pool!!!!");
    }

    @PreDestroy
    public void destroy(){
        log.info("Clean connection pool!");
    }
}
