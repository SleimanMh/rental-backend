package com.carrentalsystem.controllers;


import com.carrentalsystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/car/available/{carId}")
    public ResponseEntity<String> changeCarAvailability(@PathVariable Long carId) {
        try {
            adminService.changeCarAvailability(carId);
            return ResponseEntity.ok("Successfully updated car availability!");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Car with ID " + carId + " not found");
        }
    }
}
