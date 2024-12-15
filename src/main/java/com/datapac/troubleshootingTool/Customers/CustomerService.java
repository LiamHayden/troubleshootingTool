package com.datapac.troubleshootingTool.Customers;

import java.util.List;

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
    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println("Found Customers: " + customers);
        return customers;
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

    // add printer
    public Printer addPrinterToCustomer(Long customerId, Printer printer) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found."));

            printer.setCustomer(customer);

            customer.getPrinters().add(printer);

            return printerRepository.save(printer);
    }

    // list printers by customer
    public List<Printer> getPrintersByCustomerId(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found."))
                .getPrinters();
    }
}
