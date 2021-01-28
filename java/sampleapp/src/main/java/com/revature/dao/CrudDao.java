package com.revature.dao;

import com.revature.util.Set;

public interface CrudDao<T> {

    void save(T newObj);

    Set<T> findAll();

    T findById(int id);

    boolean update(T updObj);

    boolean deleteById(int id);
}
