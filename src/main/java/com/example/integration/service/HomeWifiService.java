package com.example.integration.service;

import com.example.integration.entity.HomeWifi;
import com.example.integration.exception.RecordNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class HomeWifiService {
    @Value("${url}")
    private String url;

    public List<HomeWifi> getWifesList(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<HomeWifi> personList = objectMapper.readValue(new URL(url), new TypeReference<List<HomeWifi>>(){});
            System.out.println(personList);
            return personList;
        } catch (IOException e) {
            System.err.println(e);
            throw new RecordNotFoundException(" List not found");
        }
    }

}
