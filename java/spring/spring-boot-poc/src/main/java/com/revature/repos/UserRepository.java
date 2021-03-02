package com.revature.repos;

import com.revature.models.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Integer> {

//    @Query("from AppUser au where au.username = :username and au.password = :password")
    AppUser findAppUserByUsernameAndPassword(String username, String password);

}
