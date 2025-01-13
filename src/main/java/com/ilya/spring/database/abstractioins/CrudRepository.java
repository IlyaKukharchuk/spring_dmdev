package com.ilya.spring.database.abstractioins;

import java.util.Optional;

public interface CrudRepository<T, ID> {
    Optional<T> findById(ID id);
    void delete(ID id);

    String getConnectionPool();
}