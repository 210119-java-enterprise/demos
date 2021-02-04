package com.revature.repo;

import com.revature.util.LinkedList;
import com.revature.util.Set;

public interface CrudRepository<T> {

    void save(T newObj);
    LinkedList<T> findAll();
    T findById(int id);
    boolean update(T updatedObj);
    boolean deleteById(int id);

}