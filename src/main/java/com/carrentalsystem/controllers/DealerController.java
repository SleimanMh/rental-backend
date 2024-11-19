package com.carrentalsystem.controllers;

import com.carrentalsystem.entities.Dealer;
import com.carrentalsystem.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealer")
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @GetMapping
    public ResponseEntity<List<Dealer>> getAll(){
        List<Dealer> dealers = dealerService.fetchAll();
        return ResponseEntity.ok(dealers);
    }

    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer){
        return dealerService.createDealer(dealer);
    }
}
