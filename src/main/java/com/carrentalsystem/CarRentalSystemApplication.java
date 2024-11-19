package com.carrentalsystem;

import com.carrentalsystem.entities.Car;
import com.carrentalsystem.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.carrentalsystem.*")
//@EntityScan(basePackages = "com.carrentalsystem.*")
public class CarRentalSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarRentalSystemApplication.class, args);
    }
//    @Bean
//    CommandLineRunner runner(CarRepository carRepository) {
//        return args -> {
//            Car car = new Car();
//            car.setId(100);
//            carRepository.save(car);
//            System.out.println("Test car added successfully!");
//        };
//    }
}
