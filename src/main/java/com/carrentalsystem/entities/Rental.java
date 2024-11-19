package com.carrentalsystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;

    private LocalDate rentalDate;

    private LocalDate returnDate;

    private int numberOfDays;

    private String status;

    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
    private Invoice invoice;
}
