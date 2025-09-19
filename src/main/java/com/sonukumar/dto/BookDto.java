package com.sonukumar.dto;

import com.sonukumar.enums.BookingStatus;
import lombok.Data;

import java.util.Date;

@Data
public class BookDto {

    private Long id;
    private String brand;
    private String name;
    private Date fromDate;
    private Date toDate;
    private Long days;
    private Long price;
    private BookingStatus bookingStatus;
    private Long userId;
    private Long carId;
    private String username;
    private String email;
    private byte[] image;
}
