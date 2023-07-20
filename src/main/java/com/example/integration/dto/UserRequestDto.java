package com.example.integration.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {
    private String series;
    private String number;
    private String birth_date;
}
