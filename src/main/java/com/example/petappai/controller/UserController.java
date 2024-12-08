package com.example.petappai.controller;

import com.example.petappai.dto.UserDTO;
import com.example.petappai.entity.User;
import com.example.petappai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/reset-password/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public User resetPassword(@PathVariable Long userId, @RequestBody String newPassword) {
        return userService.updatePassword(userId, newPassword);
    }

    @PutMapping("/toggle-lock/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public User toggleUserLock(@PathVariable Long userId, @RequestParam boolean locked) {
        return userService.toggleUserLock(userId, locked);
    }

    @DeleteMapping("/delete/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}