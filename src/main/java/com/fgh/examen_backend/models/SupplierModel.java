package com.fgh.examen_backend.models;

import javax.persistence.*;

@Entity(name = "supplier")
public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;
    private String supplierName;
    private String businessName;
    private String direction;

    public SupplierModel() {
    }

    public SupplierModel(String supplierName, String businessName, String direction) {
        this.supplierName = supplierName;
        this.businessName = businessName;
        this.direction = direction;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "SupplierModel{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}