package com.carrentalsystem.controllers;

import com.carrentalsystem.entities.Car;
import com.carrentalsystem.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService=carService;
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }
}
