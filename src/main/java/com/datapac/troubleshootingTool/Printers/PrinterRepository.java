package com.datapac.troubleshootingTool.Printers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrinterRepository extends JpaRepository<Printer, Long> {
    
}
