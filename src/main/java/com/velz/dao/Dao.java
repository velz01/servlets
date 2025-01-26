package com.velz.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K,T> {
    List<T> findAll();
    Optional<T> findById(int id);
    boolean delete();
    void update(T entity);
    T save(T entity);

}
