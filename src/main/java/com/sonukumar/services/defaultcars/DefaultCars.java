package com.sonukumar.services.defaultcars;

import com.sonukumar.dto.CarDto;
import com.sonukumar.entities.Car;
import com.sonukumar.repositories.CarRepository;
import com.sonukumar.utils.ImageUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class DefaultCars {

    private final CarRepository carRepository;

    public DefaultCars(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostConstruct
    public void addDefaultCars() {
        if (carRepository.count() == 0) { // Ensure data is added only if the table is empty
            try {
                List<Car> cars = Arrays.asList(
                        createCar("Toyota", "Red", "Corolla", "Diesel", "Manual", "Reliable and fuel-efficient sedan.", 2600L, "2022", "Goa","toyota_corolla.jpg"),
                        createCar("Hyundai_creta", "white", "Elantra", "Diesel", "Manual", "Affordable and stylish sedan with great features.", 2500L, "2022", "Chennai","Hyundai_creta.jpg"),
                        createCar("Hyundai", "Blue", "Elantra", "Hybrid", "Manual", "Affordable and stylish sedan with great features.", 2500L, "2022", "Pune","hyundai_elantra.jpg"),
                        createCar("Maruti Suzuki Alto", "Red", "Model 3", "Diesel", "Manual", "Reliable and fuel efficient", 2300L, "2023", "Delhi-NCR","maruti_suzuki_alto.jpg"),
                        createCar("Kia", "Gray", "Seltos", "Hybrid", "Manual", "Compact SUV with modern design and features.", 2800L, "2023", "Mumbai","kia_seltos.jpg"),
                        createCar("Honda", "Blue", "Civic", "Diesel", "Manual", "Sporty and reliable sedan with advanced features.", 2400L, "2021", "Hyderabad","honda_civic.jpg"),
                        createCar("Toyota", "White", "fortuner", "Diesel", "semi-automatic", "Elegant and feature-rich luxury sedan.", 4200L, "2022", "Delhi-NCR","Toyota_fortuner.webp"),
                        createCar("Nissan", "White", "Altima", "Diesel", "Automatic", "A reliable and comfortable mid-size sedan.", 5400L, "2023", "Mumbai","nissan_altima.jpg"),
                        createCar("Mahindra", "Red", "Thar", "Diesel","Manual", "Iconic off-road SUV with rugged performance.", 6000L, "2022", "Goa","Thar.jpg"),


                        createCar("Tata", "White", "Altroz", "Diesel", "Manual", "Premium hatchback with modern features and excellent mileage.", 2000L, "2023", "Pune", "tata_altroz.jpg"),
                        createCar("Hyundai", "Silver", "i20", "Petrol", "Automatic", "Stylish and feature-packed premium hatchback.", 2100L, "2022", "Bangalore", "hyundai_i20.jpg"),
                        createCar("Maruti Suzuki", "Grey", "Swift", "Petrol", "Manual", "Compact and sporty hatchback with great performance.", 1800L, "2023", "Chennai", "maruti_swift.jpg"),
                        createCar("Renault", "Blue", "Kwid", "Petrol", "Manual", "Affordable and fuel-efficient city car.", 1500L, "2022", "Mumbai", "renault_kwid.jpg"),
                        createCar("Tata", "Blue", "Tiago", "Petrol", "Manual", "Stylish hatchback with advanced safety features.", 1700L, "2023", "Delhi-NCR", "tata_tiago.jpg"),
                        createCar("Maruti Suzuki", "White", "Wagon R", "Petrol", "Manual", "Spacious and practical hatchback for family use.", 1600L, "2022", "Hyderabad", "maruti_wagon_r.jpg"),
//                        createCar("Honda", "Red", "Amaze", "Diesel", "Manual", "Compact sedan with excellent performance and comfort.", 2200L, "2022", "Pune", "honda_amaze.jpg"),
//                        createCar("Hyundai", "Silver", "Venue", "Petrol", "Automatic", "Compact SUV with premium features and great value.", 2500L, "2023", "Goa", "hyundai_venue.jpg"),
                        createCar("Kia", "White", "Sonet", "Petrol", "Manual", "Compact SUV with a bold design and tech-rich cabin.", 2600L, "2023", "Chennai", "kia_sonet.jpg"),
                        createCar("Mahindra", "Blue", "XUV300", "Diesel", "Manual", "Compact SUV with top-notch safety and performance.", 2700L, "2023", "Mumbai", "mahindra_xuv300.jpg"),
                        createCar("Maruti Suzuki", "Red", "Baleno", "Petrol", "Automatic", "Premium hatchback with smooth handling and comfort.", 2000L, "2023", "Bangalore", "maruti_baleno.jpg"),
//                        createCar("Toyota", "Silver", "Glanza", "Petrol", "Manual", "Premium hatchback with great mileage and reliability.", 1950L, "2022", "Delhi-NCR", "toyota_glanza.jpg"),
//                        createCar("Nissan", "Grey", "Magnite", "Petrol", "Manual", "Compact SUV with aggressive pricing and features.", 2400L, "2022", "Hyderabad", "nissan_magnite.jpg"),
                        createCar("Tata", "White", "Punch", "Petrol", "Manual", "Compact SUV with rugged looks and advanced safety.", 1900L, "2023", "Pune", "tata_punch.jpg"),
                        createCar("Renault", "Black", "Triber", "Petrol", "Manual", "Affordable MPV with flexible seating and spacious cabin.", 2300L, "2023", "Goa", "renault_triber.jpg")



                );

                carRepository.saveAll(cars);
                System.out.println("Default cars with images added to the database.");

            }   catch (IOException e) {
                e.printStackTrace();
                 System.err.println("Failed to load images. Default cars added without images.");
                 }
        }
    }

    private Car createCar(String brand, String color, String name, String type, String transmission, String description, Long price, String year,String location, String imageFileName) throws IOException {
        Car car = new Car();
        car.setBrand(brand);
        car.setColor(color);
        car.setName(name);
        car.setType(type);
        car.setTransmission(transmission);
        car.setDescription(description);
        car.setPrice(price);
        car.setYear(year);
        car.setLocation(location);
        car.setImage(ImageUtil.readImage(imageFileName)); // Load image bytes
        return car;
    }
}