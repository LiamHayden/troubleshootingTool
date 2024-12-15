package com.datapac.troubleshootingTool.Printers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PrinterRepository extends JpaRepository<Printer, Long> {
    List<Printer> findByCustomerId(Long customerId);
}
