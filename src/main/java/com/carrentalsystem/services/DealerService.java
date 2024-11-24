package com.carrentalsystem.services;

import com.carrentalsystem.entities.CustomerDTO;
import com.carrentalsystem.entities.Dealer;
import com.carrentalsystem.entities.DealerWithCustomersDTO;
import com.carrentalsystem.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void deleteDealer(Long id) {
        dealerRepository.deleteById(id);
    }

    public List<DealerWithCustomersDTO> getDealersWithCustomers() {
        List<Object[]> results = dealerRepository.findDealersWithCustomers();

        Map<Long, DealerWithCustomersDTO> dealerMap = new HashMap<>();

        for (Object[] row : results) {
            Long dealerId = ((Number) row[0]).longValue();
            String dealerName = (String) row[1];
            String dealerContactNumber = (String) row[2];

            Long customerId = row[3] != null ? ((Number) row[3]).longValue() : null;
            String customerName = row[4] != null ? (String) row[4] : null;
            String customerContactNumber = row[5] != null ? (String) row[5] : null;

            DealerWithCustomersDTO dealerDTO = dealerMap.computeIfAbsent(dealerId,
                    id -> new DealerWithCustomersDTO(dealerId, dealerName, dealerContactNumber, new ArrayList<>()));

            if (customerId != null) {
                dealerDTO.getCustomers().add(new CustomerDTO(customerId, customerName, customerContactNumber));
            }
        }

        return new ArrayList<>(dealerMap.values());
    }
}
