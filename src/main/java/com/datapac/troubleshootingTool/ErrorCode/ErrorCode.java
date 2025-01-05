package com.datapac.troubleshootingTool.ErrorCode;

import java.util.HashSet;
import java.util.Set;

import com.datapac.troubleshootingTool.Printers.Printer;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ErrorCode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String code;

  @ManyToMany
  @JoinTable(name = "error_code_printer", joinColumns = @JoinColumn(name = "error_code_id"), inverseJoinColumns = @JoinColumn(name = "printer_id"))
  @JsonManagedReference
  private Set<Printer> printers = new HashSet<>();

  public ErrorCode() {
  }

  public ErrorCode(String code, Set<Printer> printers) {
    this.code = code;
    this.printers = printers;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Set<Printer> getPrinters() {
    return this.printers;
  }

  public void setPrinters(Set<Printer> printers) {
    this.printers = printers;
  }
}
