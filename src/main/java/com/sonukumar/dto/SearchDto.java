package com.sonukumar.dto;

import lombok.Data;

@Data
public class SearchDto {

    private String brand;
    private String type;
    private String transmission;
    private String color;
    private String location;
    private Long price;

}
