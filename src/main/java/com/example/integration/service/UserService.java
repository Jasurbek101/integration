package com.example.integration.service;

import com.example.integration.dto.UserRequestDto;
import com.example.integration.entity.UserEntity;
import com.example.integration.exception.RecordNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JsonService jsonService;
    @Value("${url}")
    private String url;


    public UserEntity findUser(UserRequestDto user) {
        url = String.format(this.url, user.getSeries(), user.getNumber(), user.getBirth_date());
        try {
            URL newUrl = new URL(url);
            JsonNode jsonNode = jsonService.parse(newUrl);
            JsonNode node = jsonNode.get("data");
            node = node.get("data");
            return jsonService.fromJson(node, UserEntity.class);
        } catch (IOException e) {
            throw new RecordNotFoundException(" User not found");
        }
    }
}
