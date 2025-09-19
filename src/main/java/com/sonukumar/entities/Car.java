package com.sonukumar.entities;

import com.sonukumar.dto.CarDto;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "cars2")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private String transmission;
    private String description;
    private Long price;
    private String year;
    private String location;
    @Column(columnDefinition = "longblob")
    private byte[] image;

    public CarDto getCarDto() {
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setBrand(brand);
        carDto.setColor(color);
        carDto.setPrice(price);
        carDto.setDescription(description);
        carDto.setType(type);
        carDto.setTransmission(transmission);
        carDto.setYear(year);
        carDto.setLocation(location);
        carDto.setReturnedImg(image);
        return carDto;
    }


}
