package com.sonukumar.services.publicservice;

import com.sonukumar.dto.CarDto;
import com.sonukumar.dto.CarListDto;
import com.sonukumar.dto.SearchDto;
import com.sonukumar.entities.Car;
import com.sonukumar.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicServiceImpl implements PublicService {

    private final CarRepository carRepository;
    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }


    @Override
    public CarListDto searchCar(SearchDto searchDto) {
        Car car = new Car();
        car.setBrand(searchDto.getBrand());
        car.setLocation(searchDto.getLocation());
        car.setType(searchDto.getType());
        car.setTransmission(searchDto.getTransmission());
        car.setColor(searchDto.getColor());
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("brand",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("location",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("transmission",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("color",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<Car> carExample = Example.of(car, exampleMatcher);
        List<Car> carList = carRepository.findAll(carExample);
        CarListDto carListDto = new CarListDto();
        carListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carListDto;
    }
}
