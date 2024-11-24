package com.carrentalsystem.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {
    private Long invoiceId;
    private LocalDate issueDate;
    private Double amountDue;
    private String customerName;
    private String dealerName;
    private String carDetails;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private int numberOfDays;
    private String rentalStatus;

}
