package com.carrentalsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
//
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class Rental {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long rentalId;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore // Prevent cyclic references
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore // Prevent cyclic references
//    @JoinColumn(name = "dealer_id", nullable = false)
//    private Dealer dealer;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore // Prevent cyclic references
//    @JoinColumn(name = "car_id", nullable = false)
//    private Car car;
//
//    private LocalDate rentalDate;
//
//    private LocalDate returnDate;
//
//    private int numberOfDays;
//
//    private String status;
//
//    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
//    private Invoice invoice;
//}

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    private LocalDate rentalDate;

    private LocalDate returnDate;

    private int numberOfDays;

    private String status;

    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
    @JsonIgnore
    private Invoice invoice;

}
