package com.revature.controllers;

import com.revature.models.AppUser;
import com.revature.models.UserRole;
import com.revature.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository repo) {
        this.userRepo = repo;
    }

    @GetMapping
    public List<AppUser> getAllUsers() {
        return (List<AppUser>) userRepo.findAll();
    }

    @PostMapping
    public AppUser registerNewUser(@Valid @RequestBody AppUser newUser) {
        newUser.setRole(UserRole.BASIC_USER);
        newUser.setRegisterDateTime(LocalDateTime.now());
        return userRepo.save(newUser);
    }

    @PutMapping
    public AppUser updateUser(@Valid @RequestBody AppUser updatedUser) {
        return userRepo.save(updatedUser);
    }

}
