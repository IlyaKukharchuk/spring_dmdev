package com.spring;

import com.spring.database.CompanyRepository;
import com.spring.database.pool.ConnectionPool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

        var connectionPool = context.getBean("p1",ConnectionPool.class);
        System.out.println("p1: " + connectionPool);
        var connectionPool2 = context.getBean("p2",ConnectionPool.class);
        System.out.println("p2: " + connectionPool2);
        var connectionPool3 = context.getBean("p3",ConnectionPool.class);
        System.out.println("p3: " + connectionPool3);

        System.out.println();

        var connectionPool4 = context.getBean("p1",ConnectionPool.class);
        System.out.println("p1: " + connectionPool4);

        System.out.println();

        var companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        System.out.println(companyRepository);
    }
}