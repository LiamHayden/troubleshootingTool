package com.datapac.troubleshootingTool.Tickets;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

  // I don't think I'll need this but keeping for now.
  // Printer findPrinterByTicketId(Long id);
}
