package com.carrentalsystem.controllers;

import com.carrentalsystem.entities.Invoice;
import com.carrentalsystem.entities.InvoiceDTO;
import com.carrentalsystem.entities.Rental;
import com.carrentalsystem.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService=invoiceService;
    }

    @GetMapping("/{invoiceId}")
    public Optional<Invoice> getInvoice(@PathVariable Long invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping
    public List<InvoiceDTO> getAll(){
        List<Invoice> invoices =  invoiceService.fetchAll();
        return invoices.stream()
                .map(this::mapToInvoiceDTO)
                .collect(Collectors.toList());
    }

    public InvoiceDTO mapToInvoiceDTO(Invoice invoice) {
        Rental rental = invoice.getRental();
        return InvoiceDTO.builder()
                .invoiceId(invoice.getInvoiceId())
                .issueDate(invoice.getIssueDate())
                .amountDue(invoice.getAmountDue())
                .customerName(rental.getCustomer().getName())
                .dealerName(rental.getDealer().getName())
                .carDetails(rental.getCar().getBrand() + " " + rental.getCar().getModel() + " (" + rental.getCar().getYear() + ")")
                .rentalDate(rental.getRentalDate())
                .returnDate(rental.getReturnDate())
                .numberOfDays(rental.getNumberOfDays())
                .rentalStatus(rental.getStatus())
                .build();
    }
}
