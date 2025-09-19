package com.sonukumar.services.admin;

import com.sonukumar.dto.BookDto;
import com.sonukumar.dto.CarDto;
import com.sonukumar.dto.CarListDto;
import com.sonukumar.dto.SearchDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean addCar(CarDto carDto) throws IOException;

    List<CarDto> getAllCars();

    void deleteCar(Long id);

    CarDto getCarById(Long id);

    boolean updateCar(Long carId, CarDto carDto) throws IOException;

    List<BookDto> getBookings();

    boolean changeBookingStatus(Long bookingId, String status);

    CarListDto searchCar(SearchDto searchDto);

}
