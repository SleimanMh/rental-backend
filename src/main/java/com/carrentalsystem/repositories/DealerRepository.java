package com.carrentalsystem.repositories;

import com.carrentalsystem.entities.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
    @Query(value = "SELECT d.dealer_id, d.name AS dealerName, d.dealer_contact_number, " +
            "c.customer_id, c.name AS customerName, c.customer_contact_number " +
            "FROM dealer d " +
            "LEFT JOIN Cusomter_Dealer_Associations cda ON d.dealer_id = cda.dealer_id " +
            "LEFT JOIN customer c ON cda.customer_id = c.customer_id", nativeQuery = true)
    List<Object[]> findDealersWithCustomers();
}
