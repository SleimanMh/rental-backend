package com.carrentalsystem.services;

import com.carrentalsystem.entities.*;
import com.carrentalsystem.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RentalService {
    private final CustomerRepository customerRepository;

    private final DealerRepository dealerRepository;

    private final CarRepository carRepository;

    private final RentalRepository rentalRepository;

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public RentalService(CustomerRepository customerRepository, DealerRepository dealerRepository, CarRepository carRepository, RentalRepository rentalRepository, InvoiceRepository invoiceRepository) {
        this.customerRepository = customerRepository;
        this.dealerRepository = dealerRepository;
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice rentCar(String clientName, Long carId, int numberOfDays) {
        // Step 1: Validate the car's availability
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isEmpty() || optionalCar.get().isRented()) {
            throw new IllegalStateException("The selected car is not available for rent.");
        }
        Car car = optionalCar.get();

        // Step 2: Fetch or create the client
        Customer customer = customerRepository.findByName(clientName);
        if(customer==null) throw new RuntimeException("Client not found! Create the client then proceed to rent");

        // Step 3: Assign a dealer to the client
        Dealer assignedDealer = assignRandomDealer(customer);

        // Step 4: Create the rental record
        Rental rental = createRental(customer, car, assignedDealer, numberOfDays);

        // Step 5: Update the car's status
        car.setRented(true);
        carRepository.save(car);

        // Step 6: Generate the invoice
        Invoice invoice = createInvoice(rental, car.getPricePerDay() * numberOfDays);

        // Return confirmation details
        return invoice;
    }

    private Dealer assignRandomDealer(Customer customer) {
        // Fetch all dealers
        List<Dealer> dealers = dealerRepository.findAll();
        if (dealers.isEmpty()) {
            throw new IllegalStateException("No dealers available to assign.");
        }

        // Select a dealer randomly
        Dealer assignedDealer = dealers.get(new Random().nextInt(dealers.size()));

        // Ensure the client-dealer association exists
        if (!customer.getDealers().contains(assignedDealer)) {
            customer.getDealers().add(assignedDealer);
            assignedDealer.getCustomers().add(customer);
            customerRepository.save(customer);
            dealerRepository.save(assignedDealer);
        }

        return assignedDealer;
    }

    private Invoice createInvoice(Rental rental, double amountDue) {
        Invoice invoice = new Invoice();
        invoice.setRental(rental);
        invoice.setIssueDate(LocalDate.now());
        invoice.setAmountDue(amountDue);
        return invoiceRepository.save(invoice);
    }

    private Rental createRental(Customer customer, Car car, Dealer dealer, int numberOfDays) {
        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setCar(car);
        rental.setDealer(dealer);
        rental.setRentalDate(LocalDate.now());
        rental.setReturnDate(LocalDate.now().plusDays(numberOfDays));
        rental.setNumberOfDays(numberOfDays);
        rental.setStatus("Ongoing");
        return rentalRepository.save(rental);
    }

}
