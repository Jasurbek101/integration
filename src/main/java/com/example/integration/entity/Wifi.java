package com.example.integration.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wifi {
    @JsonProperty("_id")
    private String id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private List<Sensor> sensors;
}