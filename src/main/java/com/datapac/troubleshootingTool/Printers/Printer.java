package com.datapac.troubleshootingTool.Printers;

import java.util.HashSet;
import java.util.Set;

import com.datapac.troubleshootingTool.Customers.Customer;
import com.datapac.troubleshootingTool.Tickets.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "printer")
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Integer assettag;

    @ManyToMany
    @JoinTable(name = "customer_printer", joinColumns = @JoinColumn(name = "printer_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @JsonBackReference
    @JsonIgnoreProperties({ "printers" })
    private Set<Customer> customers = new HashSet<>();

    // one-to-many tickets
    @OneToMany(mappedBy = "printer")
    private Set<Ticket> Tickets;

    // constructors

    public Printer() {
    }

    public Printer(String model, Integer assettag) {
        this.model = model;
        this.assettag = assettag;
    }

    // getters and setters
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAssetTag() {
        return this.assettag;
    }

    public void setAssetTag(int assettag) {
        this.assettag = assettag;
    }

    // customer get/set
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Long getId() {
        return this.id;
    }
}
