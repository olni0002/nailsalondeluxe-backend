package dk.nailsalondeluxe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
