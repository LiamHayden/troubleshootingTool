package com.datapac.troubleshootingTool.Printers;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrinterService {
    private final PrinterRepository printerRepository;

    public PrinterService(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
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
}
