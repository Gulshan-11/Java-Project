package com.oracle.secure.repository;

import com.oracle.secure.model.User;

public interface UserRepository  {
    User findByUsername(String username);
    User save(User user);
}