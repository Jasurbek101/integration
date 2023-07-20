package com.example.integration.controller;


import com.example.integration.dto.ApiResponse;
import com.example.integration.dto.UserRequestDto;
import com.example.integration.entity.UserEntity;
import com.example.integration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<UserEntity> findUser(@RequestBody UserRequestDto user) {
        System.err.println(user);
        UserEntity serviceUser = userService.findUser(user);
        return ApiResponse.<UserEntity>builder()
                .success(true)
                .message("Hello ".concat(serviceUser.getName().concat(" bro")))
                .status(200)
                .data(serviceUser)
                .build();
    }

}
