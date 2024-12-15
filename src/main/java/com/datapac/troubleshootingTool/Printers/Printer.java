package com.datapac.troubleshootingTool.Printers;

import com.datapac.troubleshootingTool.Customers.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Printer {
    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private int assetTag;

    // many-to-one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    // constructors

    public Printer(){}

    public Printer(String model, int assetTag, Customer customer) {
        this.model = model;
        this.assetTag = assetTag;
        this.customer = customer;
    }

    // getters and setters
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAssetTag() {
        return this.assetTag;
    }

    public void setAssetTag(int assetTag) {
        this.assetTag = assetTag;
    }

    // customer get/set
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
