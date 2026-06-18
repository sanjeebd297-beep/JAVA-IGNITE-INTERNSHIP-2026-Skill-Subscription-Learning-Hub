package com.skills.hub.service.impl;

import com.skills.hub.model.User;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Service;

/*
=========================================================
WHAT IS THIS CLASS?
=========================================================
This class contains BUSINESS LOGIC for users.
 Controller calls this
 This class talks to repository
=========================================================
*/

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User user) {
        // STEP 1: check if email already exists
        User existing = userRepo.findByEmail(user.getEmail());

        // STEP 2: if exists → stop process
        if (existing != null) {
            return null;
        }
        // STEP 3: if not → save user to DB
        // STEP 4: return saved user
        else {
            return userRepo.save(user);
        }
    }

    @Override
    public User login(String email, String password) {
        // STEP 1: find user by email
        User user = userRepo.findByEmail(email);

        // STEP 2: if user not found → return null
        if (user == null) {
            return null;
        }
        // STEP 3: check password match
        // STEP 4: if correct → return user
        // STEP 5: else → return null
        else {
            if (user.getPassword().equals(password)) {
                return user;
            }
            else {
                return null;
            }
        }
    }
}
