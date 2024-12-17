package com.datapac.troubleshootingTool.dto;

import java.util.Objects;

public class PrinterDetailedResponse {
    private Long id;
    private String model;
    private Integer assetTag;

    // Default constructor for Jackson
    public PrinterDetailedResponse() {}

    // Constructor with arguments
    public PrinterDetailedResponse(Long id, String model, Integer assetTag) {
        this.id = id;
        this.model = model;
        this.assetTag = assetTag;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(Integer assetTag) {
        this.assetTag = assetTag;
    }

    @Override
    public String toString() {
        return "PrinterDetailedResponse{id=" + id + ", model='" + model + "', assetTag=" + assetTag + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrinterDetailedResponse that = (PrinterDetailedResponse) o;
        return assetTag == that.assetTag && id.equals(that.id) && model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, assetTag);
    }
}
