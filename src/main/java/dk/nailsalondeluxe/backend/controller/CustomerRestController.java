package dk.nailsalondeluxe.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.nailsalondeluxe.backend.model.Customer;
import dk.nailsalondeluxe.backend.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {
    
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCategories() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id) {
        return customerRepository.findById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
        customer.setId(id);
        customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerRepository.deleteById(id);
    }

}
