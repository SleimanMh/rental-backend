package com.carrentalsystem.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DealerWithCustomersDTO {
    private Long dealerId;
    private String dealerName;
    private String dealerContactNumber;
    private List<CustomerDTO> customers;
}


