package com.carrentalsystem.services;

import com.carrentalsystem.entities.Car;
import com.carrentalsystem.exceptions.CarNotFoundException;
import com.carrentalsystem.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AdminService {
    private final CarRepository carRepository;

    @Autowired
    public AdminService(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    public void changeCarAvailability(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car with ID " + carId + " not found"));

        car.setRented(false);
        carRepository.save(car);
    }
}
