package com.example.integration.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class JsonService {
    private ObjectMapper objectMapper = getDefaultObjectMapper();

    private ObjectMapper getDefaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public JsonNode parse(URL url) throws IOException {
        return objectMapper.readTree(url);
    }

    public <T> List<T> listFromJson(JsonNode node, Class<T> customClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, customClass);
        return objectMapper.readValue(node.traverse(), type);
    }

    public <T> T fromJson(JsonNode node, Class<T> customClass) throws IOException {
        return objectMapper.readValue(node.traverse(), customClass);
    }
}
