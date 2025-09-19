package com.sonukumar.controllers;
import com.sonukumar.dto.CarDto;
import com.sonukumar.dto.SearchDto;
import com.sonukumar.services.publicservice.PublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class PublicController {
    private final PublicService publicService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars(){
        List<CarDto> carDtoList = publicService.getAllCars();
        return ResponseEntity.ok(carDtoList);
    }

    // search for car
    @PostMapping("/car/search")
    public ResponseEntity<?> search(@RequestBody SearchDto searchDto) {
        return ResponseEntity.ok(publicService.searchCar(searchDto));
    }

}
