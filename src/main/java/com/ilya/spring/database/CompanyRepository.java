package com.ilya.spring.database;

import com.ilya.spring.bpp.Transaction;
import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.entity.Company;
import com.ilya.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transaction
public class CompanyRepository implements CrudRepository<Company, Integer> {
    private final ConnectionPool pool;
    private final List<ConnectionPool> pools;
    private final Integer poolSize;

    public CompanyRepository(ConnectionPool pool,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool = pool;
        this.pools = pools;
        this.poolSize = poolSize;
    }


    @PostConstruct
    private void init(){
        System.out.println("init CompanyRepository! POOL SIZE IS: " + poolSize);
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
        if(this.pool != null) {
            return this.pool.toString();
        }else {
            System.out.println("POOL SIZE IS: ");
            return poolSize.toString();
        }
    }
}