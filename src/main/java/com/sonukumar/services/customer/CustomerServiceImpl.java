package com.sonukumar.services.customer;

import com.sonukumar.dto.BookDto;
import com.sonukumar.dto.CarDto;
import com.sonukumar.dto.CarListDto;
import com.sonukumar.dto.SearchDto;
import com.sonukumar.entities.Book;
import com.sonukumar.entities.Car;
import com.sonukumar.entities.User;
import com.sonukumar.enums.BookingStatus;
import com.sonukumar.repositories.BookRepository;
import com.sonukumar.repositories.CarRepository;
import com.sonukumar.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class
CustomerServiceImpl implements CustomerService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookCar(BookDto bookDto) {
        Optional<Car> optionalCar = carRepository.findById(bookDto.getCarId());
        Optional<User> optionalUser = userRepository.findById(bookDto.getUserId());

        if (optionalCar.isPresent() && optionalUser.isPresent()) {
            Car existingCar = optionalCar.get();
            Book book = new Book();
            book.setUser(optionalUser.get());
            book.setCar(existingCar);
            book.setBookingStatus(BookingStatus.PENDING);
            long diffInMilliSeconds = bookDto.getToDate().getTime() - bookDto.getFromDate().getTime();
            long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds);
            book.setDays(days);
            book.setPrice(existingCar.getPrice() * days);
            book.setFromDate(bookDto.getFromDate());
            book.setToDate(bookDto.getToDate());
            book.setName(bookDto.getName());
            book.setBrand(bookDto.getBrand());
            book.setImage(bookDto.getImage());
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public List<BookDto> getBookingByUserId(Long userId) {
        return bookRepository.findAllByUserId(userId).stream().map(Book::getBookCarDto).collect(Collectors.toList());
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
