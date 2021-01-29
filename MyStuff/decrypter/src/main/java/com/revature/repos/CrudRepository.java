package com.revature.repos;

import com.revature.util.Set;

public interface CrudRepository<T> {

    void save(T newObj);
    Set<T> findAll();
    T findById(int id);
    boolean update(T updatedObj);
    boolean deleteById(int id);

}
