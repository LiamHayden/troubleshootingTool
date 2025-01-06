package com.datapac.troubleshootingTool.AssetTag;

import com.datapac.troubleshootingTool.Printers.Printer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity
public class AssetTag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagNumber;

    // ONE-TO-ONE PRINTER

    @OneToOne(mappedBy = "assetTag", cascade = CascadeType.ALL)
    @JsonBackReference
    private Printer printer;

    // CONSTRUCTORS
    public AssetTag() {
    }

    public AssetTag(String tagNumber, Printer printer) {
        this.tagNumber = tagNumber;
        this.printer = printer;
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
}
