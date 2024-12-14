package com.datapac.troubleshootingTool.Customers;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // create
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // read all
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    // read by id
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    // update
    public Customer updateCustomer(Customer customer, Long id) {
        Customer foundCustomer = customerRepository.findById(id).get();

        foundCustomer.setName(customer.getName());
        foundCustomer.setAccessUrl(customer.getAccessUrl());

        return customerRepository.save(foundCustomer);
    }

    // delete
    public String deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return "Customer deleted.";
    }
}
