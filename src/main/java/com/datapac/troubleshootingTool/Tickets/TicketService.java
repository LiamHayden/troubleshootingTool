package com.datapac.troubleshootingTool.Tickets;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

  private final TicketRepository ticketRepository;

  public TicketService(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  // read all
  public List<Ticket> findAllTickets() {
    return ticketRepository.findAll();
  }

  // read by id
  public Ticket findByTicketId(Long id) {
    return ticketRepository.findById(id).get();
  }

  // read printer by ticket_id
  // public Printer findPrinterByTicketId(Long id) {
  // return ticketRepository.findPrinterById(id);
  // }
}
