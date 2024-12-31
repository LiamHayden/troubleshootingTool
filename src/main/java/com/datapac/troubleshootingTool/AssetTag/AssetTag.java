package com.datapac.troubleshootingTool.AssetTag;

import java.util.List;

import com.datapac.troubleshootingTool.Printers.Printer;
import com.datapac.troubleshootingTool.Tickets.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity
public class AssetTag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "printer_id")
    private Printer printer;

    @OneToMany(mappedBy = "assetTag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    public AssetTag() {
    }

    public AssetTag(String tagNumber, Printer printer, List<Ticket> tickets) {
        this.tagNumber = tagNumber;
        this.printer = printer;
        this.tickets = tickets;
    }

    public AssetTag(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getTagNumber() {
        return this.tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
