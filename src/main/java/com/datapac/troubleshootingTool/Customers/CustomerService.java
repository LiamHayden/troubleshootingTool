package com.datapac.troubleshootingTool.Customers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.datapac.troubleshootingTool.Printers.Printer;
import com.datapac.troubleshootingTool.Printers.PrinterRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PrinterRepository printerRepository;

    public CustomerService(CustomerRepository customerRepository, PrinterRepository printerRepository) {
        this.customerRepository = customerRepository;
        this.printerRepository = printerRepository;
    }

    // create
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // read all
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println("CustomerService: " + customers);  // Check the data here
        return customers;
    }

    // find all printers by customer
    public List<Printer> getPrintersByCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.map(c -> new ArrayList<>(c.getPrinters())).orElseGet(null);
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
