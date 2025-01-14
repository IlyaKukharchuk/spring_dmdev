package com.ilya.spring;

import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.pool.ConnectionPool;
import com.ilya.spring.database.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {

            var connectionPool = context.getBean("pool", ConnectionPool.class);
            System.out.println("pool: " + connectionPool);

            System.out.println();

            var crudRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(crudRepository);
            System.out.println("connectionPool: " + crudRepository.getConnectionPool());
        }
    }
}
