package com.carrentalsystem.services;

import com.carrentalsystem.entities.Dealer;
import com.carrentalsystem.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {
    @Autowired
    private DealerRepository dealerRepository;

    public Dealer createDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    public List<Dealer> fetchAll() {
        return dealerRepository.findAll();
    }
}
