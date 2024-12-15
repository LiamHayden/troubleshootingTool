package com.datapac.troubleshootingTool.dto;

import java.util.List;

import com.datapac.troubleshootingTool.Printers.Printer;

public class CustomerDetailsDTO {
    private String accessUrl;
    private List<Printer> printers;

    public String getAccessUrl() {
        return this.accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public List<Printer> getPrinters() {
        return this.printers;
    }

    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }
}
