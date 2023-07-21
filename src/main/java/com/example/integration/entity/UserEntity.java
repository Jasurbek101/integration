package com.example.integration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {
    private Long pinfl;
    private String series ;
    private String number;
    private String sur_name;
    private String name;
    private String patronymic_name;
    private String full_name;
    private String birth_date ;
    private String birth_place;
    private String given_date;
    private String expiration_date;
    private String given_place;
    private String living_place;
    private String address;
    private int region_id;
    private int district_id ;
    private int status ;
    private int gender;
    private String citizenship;
    private int citizenship_id;
}
