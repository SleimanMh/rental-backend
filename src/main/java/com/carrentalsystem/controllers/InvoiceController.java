package com.carrentalsystem.controllers;

import com.carrentalsystem.entities.Invoice;
import com.carrentalsystem.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
}
