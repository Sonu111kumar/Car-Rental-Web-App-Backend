package com.sonukumar.services.publicservice;

import com.sonukumar.dto.CarDto;
import com.sonukumar.dto.CarListDto;
import com.sonukumar.dto.SearchDto;

import java.util.List;

public interface PublicService {

    List<CarDto> getAllCars();
    CarListDto searchCar(SearchDto searchDto);
}
