package com.ilya.spring;

import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.pool.ConnectionPool;
import com.ilya.spring.database.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var connectionPool = context.getBean("p1", ConnectionPool.class);
            System.out.println("p1: " + connectionPool);
            var connectionPool2 = context.getBean("p2", ConnectionPool.class);
            System.out.println("p2: " + connectionPool2);
            var connectionPool3 = context.getBean("p3", ConnectionPool.class);
            System.out.println("p3: " + connectionPool3);

            System.out.println();

            var connectionPool4 = context.getBean("p1", ConnectionPool.class);
            System.out.println("p1: " + connectionPool4);

            System.out.println();

            var crudRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(crudRepository);
            System.out.println("connectionPool: " + crudRepository.getConnectionPool());
        }
    }
}
