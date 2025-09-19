package com.sonukumar.services.customer;

import com.sonukumar.dto.BookDto;
import com.sonukumar.dto.CarDto;
import com.sonukumar.dto.CarListDto;
import com.sonukumar.dto.SearchDto;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    boolean bookCar(BookDto bookDto);

    CarDto getCarById(Long carId);

    List<BookDto> getBookingByUserId(Long userId);

    CarListDto searchCar(SearchDto searchDto);

}
