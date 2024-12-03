package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.nailsalondeluxe.backend.model.Customer;
import dk.nailsalondeluxe.backend.repository.CustomerRepository;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        customers.forEach(customer -> Hibernate.initialize(customer.getReservations()));

        return customers;
    }

    @Transactional(readOnly = true)
    public Optional<Customer> getCustomer(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        
        Hibernate.initialize(customer.get().getReservations());
        
        return customer;
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer, int id) {
        customer.setId(id);
        customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
