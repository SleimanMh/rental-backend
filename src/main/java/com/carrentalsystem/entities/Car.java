package com.carrentalsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id
    private Long id;
    private String model;
    private String brand;
    private int year;
    private float efficiency;
    private double dailyRent;
    private boolean isRented;

    @Column(nullable = false)
    private float pricePerDay;

    @JsonIgnore
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rental> rentals;

}
