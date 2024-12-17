package com.datapac.troubleshootingTool.Printers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.datapac.troubleshootingTool.Customers.Customer;
import com.datapac.troubleshootingTool.Customers.CustomerRepository;

@Service
public class PrinterService {
    private final PrinterRepository printerRepository;

    private CustomerRepository customerRepository;

    public PrinterService(PrinterRepository printerRepository, CustomerRepository customerRepository) {
        this.printerRepository = printerRepository;
        this.customerRepository = customerRepository;
    }

    // create
    public Printer createPrinter(Printer printer) {
        return printerRepository.save(printer);
    }

    // read all
    public List<Printer> findAllPrinters() {
        return printerRepository.findAll();
    }

    // read by id
    public Printer findPrinterById(Long id) {
        return printerRepository.findById(id).get();
    }

    // update
    public Printer updatePrinter(Printer printer, Long id) {
        Printer foundPrinter = printerRepository.findById(id).get();

        foundPrinter.setModel(printer.getModel());
        foundPrinter.setAssetTag(printer.getAssetTag());

        return printerRepository.save(foundPrinter);
    }

    // delete
    public String deletePrinter(Long id) {
        printerRepository.deleteById(id);
        return "Customer deleted.";
    }

    public List<Printer> findPrintersByCustomerId(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return printerRepository.findPrintersByCustomer(customerId);
        } else {
            return Collections.emptyList();
        }
    }
}
