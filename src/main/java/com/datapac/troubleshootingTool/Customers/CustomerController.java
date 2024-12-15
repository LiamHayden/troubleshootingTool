package com.datapac.troubleshootingTool.Customers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapac.troubleshootingTool.Printers.Printer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // create
    @PostMapping("/new")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    // read all
    @GetMapping("/all")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    // read by id
    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    // update
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        return customerService.updateCustomer(customer, id);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

    // add print to a customer
    @PostMapping("/{customerId}/printers")
    public Printer addPrinterToCustomer(@RequestBody Printer printer, @PathVariable Long customerId) {
        return customerService.addPrinterToCustomer(customerId, printer);
    }

    // list printers by customer
    @GetMapping("/{customerId}/printers")
    public List<Printer> getPrintersByCustomerId(@PathVariable Long customerId) {
        return customerService.getPrintersByCustomerId(customerId);
    }
}
