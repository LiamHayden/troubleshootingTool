package com.datapac.troubleshootingTool.Tickets;

import com.datapac.troubleshootingTool.AssetTag.AssetTag;
import com.datapac.troubleshootingTool.Printers.Printer;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String number;

  // many-to-one relationship with assetTag
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "asset_tag_id")
  private AssetTag assetTag;

  // one-to-many printer_id
  @ManyToOne
  @JoinColumn(name = "printer_id", nullable = false)
  private Printer printer;

  // one-to-many customer_id

  // one-to-many error_code_id

  // constructors
  public Ticket() {
  }

  public Ticket(String number, Printer printer) {
    this.number = number;
    this.printer = printer;
  }

  // getters and setters
  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Printer getPrinter() {
    return this.printer;
  }

  public void setPrinter(Printer printer) {
    this.printer = printer;
  }

  public AssetTag getAssetTag() {
    return assetTag;
  }

  public void setAssetTag(AssetTag assetTag) {
      this.assetTag = assetTag;
  }

}
