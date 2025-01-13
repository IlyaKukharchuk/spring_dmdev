package com.ilya.spring.database;

import com.ilya.spring.bpp.InjectBean;
import com.ilya.spring.bpp.Transaction;
import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.entity.Company;
import com.ilya.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;

import java.util.Optional;

@Transaction
public class CompanyRepository implements CrudRepository<Company, Integer> {
    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init(){
        System.out.println("init CompanyRepository!");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method ...");
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        System.out.println("delete method ...");
    }

    @Override
    public String getConnectionPool() {
        if(this.connectionPool != null) {
            return this.connectionPool.toString();
        }else {
            return "connectionPool is null :(";
        }
    }
}