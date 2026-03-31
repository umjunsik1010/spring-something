package com.example.umjunsik.controller;

import com.example.umjunsik.domain.User;
import com.example.umjunsik.dto.UserRegistrationRequestDto;
import com.example.umjunsik.dto.UserSimpleResponseDto;
import com.example.umjunsik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<UserSimpleResponseDto> registerUser(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
        User user = new User(
                userRegistrationRequestDto.getUsername(),
                userRegistrationRequestDto.getPassword(),
                userRegistrationRequestDto.getName()
        );
        UserSimpleResponseDto savedUser = userService.saveUser(user);

        return ResponseEntity.ok(savedUser);
    }
}
