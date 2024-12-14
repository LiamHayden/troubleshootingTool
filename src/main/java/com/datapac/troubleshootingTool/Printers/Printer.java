package com.datapac.troubleshootingTool.Printers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Printer {
    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private int assetTag;

    // constructors

    public Printer(){}

    public Printer(String model, int assetTag) {
        this.model = model;
        this.assetTag = assetTag;
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
}
