package com.carrentalsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
//public class Invoice {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long invoiceId;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JsonManagedReference
//    @JoinColumn(name = "rental_id", nullable = false)
//    private Rental rental;
//
//    @Column(nullable = false, name="issue_date")
//    private LocalDate issueDate;
//
//    @Column(nullable = false, name = "admount_due")
//    private Double amountDue;
//}

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;


    @Column(nullable = false, name="issue_date")
    private LocalDate issueDate;

    @Column(nullable = false, name = "admount_due")
    private Double amountDue;
}
