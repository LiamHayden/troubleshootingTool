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
import com.datapac.troubleshootingTool.Question.Question;
import com.datapac.troubleshootingTool.Tickets.Ticket;
import com.datapac.troubleshootingTool.Tickets.TicketService;

import com.datapac.troubleshootingTool.Question.*;

@Controller
public class IndexController {

    private final CustomerService customerService;

    private final PrinterService printerService;

    private final TicketService ticketService;
    
    private final QuestionRepository questionRepository;

    public IndexController(CustomerService customerService, PrinterService printerService, TicketService ticketService, QuestionRepository questionRepository) {
        this.customerService = customerService;
        this.printerService = printerService;
        this.ticketService = ticketService;
        this.questionRepository = questionRepository;
    }

    // INDEX
    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "index";
    }

    // SEARCH RESULTS
    @GetMapping("/search")
    public String searchResults(Model model) {
        // TICKET
        List<Ticket> tickets = ticketService.findAllTickets();
        model.addAttribute("tickets", tickets);

        // CUSTOMER
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);

        //  PRINTER
        List<Printer> printers = printerService.findAllPrinters();
        model.addAttribute("printers", printers);

        return "search-result";
    }

    // SEARCH RESULTS - NOT USED
    // @GetMapping("/index/search/{searchTerm}")
    // public String searchResults(@PathVariable String searchTerm, Model model) {
    //     List<Customer> customers = customerService.searchCustomers(searchTerm);
    //     model.addAttribute("customers", customers);
    //     return "index";
    // }

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

    // GET PRINTER BASED ON TICKET
    // @GetMapping("/index/tickets/{ticketId}/printers")
    // public Printer getPrinterByTicketId(@PathVariable Long ticketId) {
    //     Printer printer = printerService.findPrinterByTicketId(ticketId);
    //     return printer;
    // }
    
    @GetMapping("/index/question/description/{id}")
	public Model findQuestionByProblem(@PathVariable Long id, Model model) {
		Question question = questionRepository.findById(id).get();
		return model.addAttribute("question", question);
//		return question.getQuestionDescription();
	}

}
