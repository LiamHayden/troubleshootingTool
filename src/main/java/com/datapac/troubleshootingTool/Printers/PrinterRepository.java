package com.datapac.troubleshootingTool.Printers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PrinterRepository extends JpaRepository<Printer, Long> {

    @Query("SELECT p FROM Printer p JOIN p.customers c WHERE c.id = :customerId")
    List<Printer> findPrintersByCustomer(@Param("customerId") Long customerId);
}
