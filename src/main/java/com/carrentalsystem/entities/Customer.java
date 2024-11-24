package com.carrentalsystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long cutomserId;

    @Column(name="name")
    private String name;

    @Column(name="customer_contact_number")
    private String customerContactNumber;

    @Column(name="DOB")
    private Date date_of_birth;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="age")
    private int age =10;

    @ManyToMany(mappedBy = "customers")
    private Set<Dealer> dealers;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Rental> rentals;
}
