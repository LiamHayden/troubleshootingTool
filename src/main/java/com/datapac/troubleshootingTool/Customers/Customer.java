package com.datapac.troubleshootingTool.Customers;

import java.util.HashSet;
import java.util.Set;

import com.datapac.troubleshootingTool.Printers.Printer;
import com.datapac.troubleshootingTool.Tickets.Ticket;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String accessUrl;

    @ManyToMany
    @JoinTable(name = "customer_printer", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "printer_id"))
    @JsonManagedReference
    private Set<Printer> printers = new HashSet<>();

    // ONE-TO-MANY TICKETS
    @OneToMany(mappedBy = "customer")
    private Set<Ticket> Tickets;

    // constructors

    public Customer() {
    }

    public Customer(String name, String accessUrl, Set<Printer> printers) {
        this.name = name;
        this.accessUrl = accessUrl;
        this.printers = printers;
    }

    // getters and setters

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessUrl() {
        return this.accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    // printers get/set
    public Set<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(Set<Printer> printers) {
        this.printers = printers;
    }

}
