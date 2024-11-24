package com.carrentalsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dealer_id")
    private Long dealerId;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name="dealer_contact_number")
    private String dealerContactNumber;

    @Column(name="DOB")
    private Date date_of_birth;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "Cusomter_Dealer_Associations",
            joinColumns = @JoinColumn(name = "dealer_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;

    @JsonIgnore
    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<Rental> rentals;
}
