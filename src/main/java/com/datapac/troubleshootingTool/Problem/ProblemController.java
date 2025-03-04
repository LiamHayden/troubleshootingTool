package com.datapac.troubleshootingTool.Problem;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problems")
public class ProblemController {
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    // create
//    @PostMapping("/new")
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return customerService.createCustomer(customer);
//    }

    // read all
    @GetMapping("/all")
    public List<Problem> findAllProblems() {
        return problemService.getAllProblems();
    }

    // GET PRINTERS
//    @GetMapping("/{customerId}/printers")
//    public List<Printer> getPrinters(@PathVariable Long customerId) {
//        return customerService.getPrintersByCustomer(customerId);
//    }

    @GetMapping("/problem/{id}")
    public ResponseEntity<Problem> getProblem(@PathVariable Long id) {
    	Problem problem = problemService.findProblemById(id);
        if (problem != null) {
            return ResponseEntity.ok(problem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // update
//    @PutMapping("/update/{id}")
//    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
//        return customerService.updateCustomer(customer, id);
//    }
//
//    // delete
//    @DeleteMapping("/delete/{id}")
//    public String deleteCustomer(@PathVariable Long id) {
//        return customerService.deleteCustomer(id);
//    }
}
