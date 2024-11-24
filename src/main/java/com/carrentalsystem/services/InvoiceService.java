package com.carrentalsystem.services;

import com.carrentalsystem.entities.Invoice;
import com.carrentalsystem.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository=invoiceRepository;
    }

    public Optional<Invoice> getInvoice(Long invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    public List<Invoice> fetchAll() {
        return invoiceRepository.findAll();
    }
}
