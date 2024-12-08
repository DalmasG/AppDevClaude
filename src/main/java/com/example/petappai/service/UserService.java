package com.example.petappai.service;

import com.example.petappai.dto.UserDTO;
import com.example.petappai.entity.User;

public interface UserService {
    // Create a new user
    User createUser(UserDTO userDTO);

    // Update user password
    User updatePassword(Long userId, String newPassword);

    // Toggle user lock status
    User toggleUserLock(Long userId, boolean locked);

    // Delete user
    void deleteUser(Long userId);

    // Find user by username
    User findByUsername(String username);
}