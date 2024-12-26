package com.datapac.troubleshootingTool.Tickets;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  // read all
  @GetMapping("/all")
  public List<Ticket> findAllTickets() {
    return ticketService.findAllTickets();
  }

  // read by id
  @GetMapping("/{id}")
  public Ticket findByTicketId(@PathVariable Long id) {
    return ticketService.findByTicketId(id);
  }

  // read printer by ticket_id
  // @GetMapping("/printer/{id}")
  // public Printer findPrinterByTicketId(@PathVariable Long id) {
  // return ticketService.findPrinterByTicketId(id);
  // }

}
