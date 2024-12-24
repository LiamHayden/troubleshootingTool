package com.datapac.troubleshootingTool.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.datapac.troubleshootingTool.Customers.Customer;
import com.datapac.troubleshootingTool.Customers.CustomerService;
import com.datapac.troubleshootingTool.Printers.Printer;
import com.datapac.troubleshootingTool.Printers.PrinterService;

@Controller
public class IndexController {

    private final CustomerService customerService;

    private final PrinterService printerService;

    public IndexController(CustomerService customerService, PrinterService printerService) {
        this.customerService = customerService;
        this.printerService = printerService;
    }

    // INDEX
    @GetMapping("/index")
    public String index(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "index";
    }

    // GET PRINTERS BASED ON CUSTOMER ID
    @GetMapping("/index/customers/{customerId}/printers")
    public ResponseEntity<List<Printer>> getPrintersByCustomerId(@PathVariable Long customerId) {
        List<Printer> printers = printerService.findPrintersByCustomerId(customerId);
        if (printers != null && !printers.isEmpty()) {
            return ResponseEntity.ok(printers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // GET CUSTOMER BY ID - FOR ACCESS URL
    @GetMapping("/index/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
