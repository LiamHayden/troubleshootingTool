package com.datapac.troubleshootingTool.Customers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datapac.troubleshootingTool.Printers.Printer;
import com.datapac.troubleshootingTool.Printers.PrinterService;
import com.datapac.troubleshootingTool.dto.CustomerDetailsDTO;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    private final PrinterService printerService;

    public CustomerController(CustomerService customerService, PrinterService printerService) {
        this.customerService = customerService;
        this.printerService = printerService;
    }

    // create
    @PostMapping("/new")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    // read all
    @GetMapping("/all")
    public String findAllCustomers(Model model) {
        List<Customer> customers = customerService.findAllCustomers();
        System.out.println("Customers: " + customers);
        model.addAttribute("customers", customers);

        model.addAttribute("selectedCustomer", customers.isEmpty() ? null : customers.get(0));
        return "index";
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

    // get customer details
    @GetMapping("/customer-details/{id}")
    @ResponseBody
    public CustomerDetailsDTO getCustomerDetails(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);

        List<Printer> printers = printerService.getPrintersByCustomerId(id);

        CustomerDetailsDTO customerDetails = new CustomerDetailsDTO();
        customerDetails.setAccessUrl(customer.getAccessUrl());
        customerDetails.setPrinters(printers);

        return customerDetails;
    }
}
