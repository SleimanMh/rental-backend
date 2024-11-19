package com.carrentalsystem.services;

import com.carrentalsystem.entities.Car;
import com.carrentalsystem.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        cars.forEach(System.out::println);
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }
}
