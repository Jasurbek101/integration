package com.example.integration.controller;


import com.example.integration.dto.ApiResponse;
import com.example.integration.entity.HomeWifi;
import com.example.integration.service.HomeWifiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wifi")
public class HomeController {
    private final HomeWifiService homeWifiService;
    @GetMapping
    public ApiResponse<List<HomeWifi>> findUser() {
        List<HomeWifi> wifesList = homeWifiService.getWifesList();
        return ApiResponse.<List<HomeWifi>>builder()
                .success(true)
                .message( " Here !!! " )
                .status(200)
                .data(wifesList)
                .build();
    }
}

