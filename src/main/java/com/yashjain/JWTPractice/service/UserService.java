package com.yashjain.JWTPractice.service;

import com.yashjain.JWTPractice.domain.Role;
import com.yashjain.JWTPractice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String userName);

    List<User> getUsers();
}
