package com.microtech.customerApplication.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "tblorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordId;
    private String orddate;
    private int custId;
    private int empId;
    private int prodId;
    private String shipingDate;
    private String deliveryDate;


    public Order(int ordId, String orddate, int custId, int empId, int prodId, String shipingDate, String deliveryDate) {
        this.ordId = ordId;
        this.orddate = orddate;
        this.custId = custId;
        this.empId = empId;
        this.prodId = prodId;
        this.shipingDate = shipingDate;
        this.deliveryDate = deliveryDate;
    }

    public Order() {

    }

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public String getOrddate() {
        return orddate;
    }

    public void setOrddate(String orddate) {
        this.orddate = orddate;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getShipingDate() {
        return shipingDate;
    }

    public void setShipingDate(String shipingDate) {
        this.shipingDate = shipingDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}







