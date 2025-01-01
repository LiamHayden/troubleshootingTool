package com.datapac.troubleshootingTool.Printers;

import java.util.HashSet;
import java.util.Set;

import com.datapac.troubleshootingTool.AssetTag.AssetTag;
import com.datapac.troubleshootingTool.Customers.Customer;
import com.datapac.troubleshootingTool.ErrorCode.ErrorCode;
import com.datapac.troubleshootingTool.Tickets.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "printer")
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    // ONE-TO-ONE ASSET TAG
    @OneToOne
    @JoinColumn(name = "asset_tag_id")
    @JsonManagedReference
    private AssetTag assetTag;

    // MANY-TO-MANY CUSTOMERS
    @ManyToMany
    @JoinTable(name = "customer_printer", joinColumns = @JoinColumn(name = "printer_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @JsonBackReference
    @JsonIgnoreProperties({ "printers" })
    private Set<Customer> customers = new HashSet<>();

    // MANY-TO-MANY ERROR CODES
    @ManyToMany
    @JoinTable(name = "error_code_printer", joinColumns = @JoinColumn(name = "printer_id"), inverseJoinColumns = @JoinColumn(name = "error_code_id"))
    @JsonManagedReference
    @JsonIgnoreProperties({ "printers" })
    private Set<ErrorCode> errorCOdes = new HashSet<>();

    // ONE-TO-MANY TICKETS
    @OneToMany(mappedBy = "printer")
    private Set<Ticket> Tickets;

    // constructors

    public Printer() {
    }

    public Printer(String model) {
        this.model = model;
    }

    // getters and setters
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // assetTag get/set
    public AssetTag getAssetTag() {
        return assetTag;
    }

    // public void setAssetTag(AssetTag assetTag) {
    //     this.assetTag = assetTag;
    //     assetTag.setPrinter(this);
    // }

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
