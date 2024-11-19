package com.carrentalsystem.controllers;

import com.carrentalsystem.entities.Invoice;
import com.carrentalsystem.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService){
        this.rentalService=rentalService;
    }

    @PostMapping
    public ResponseEntity<Invoice> rentCar(
            @RequestParam String clientName,
            @RequestParam Long carId,
            @RequestParam int numberOfDays) {
        Invoice invoice = rentalService.rentCar(clientName, carId, numberOfDays);
        return ResponseEntity.ok(invoice);
    }

}
