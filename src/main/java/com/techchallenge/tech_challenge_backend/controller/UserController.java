package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.dto.UserDTOs.*;
import com.techchallenge.tech_challenge_backend.model.User;
import com.techchallenge.tech_challenge_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserResponseDTO> getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateLogin(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.validateLogin(loginDTO));
    }

    @PostMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordDTO dto) {
        return ResponseEntity.ok(userService.changePassword(dto));
    }
}
