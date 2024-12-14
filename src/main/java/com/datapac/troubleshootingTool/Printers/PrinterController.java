package com.datapac.troubleshootingTool.Printers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/printers")
public class PrinterController {
    private final PrinterService printerService;

    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }

    // create
    @PutMapping("/new")
    public Printer createPrinter(@RequestBody Printer printer) {
        return printerService.createPrinter(printer);
    }

    // read all
    @GetMapping("/all")
    public List<Printer> findAllPrinters() {
        return printerService.findAllPrinters();
    }

    // read by id
    @GetMapping("/{id}")
    public Printer findPrinterById(@PathVariable Long id) {
        return printerService.findPrinterById(id);
    }

    // update
    @PostMapping("/update/{id}")
    public Printer updatePrinter(@RequestBody Printer printer, @PathVariable Long id) {
        return printerService.updatePrinter(printer, id);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String deletePrinter(@PathVariable Long id) {
        return printerService.deletePrinter(id);
    }
}
