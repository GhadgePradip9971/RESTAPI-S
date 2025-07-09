package com.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ElectricityBill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String name;
    private int currentReading;
    private int previousReading;
    private int units;
    private double serviceCharge;
    private double totalBill;

    public ElectricityBill() {
        super();
    }

    public ElectricityBill(int cid, String name, int currentReading, int previousReading, int units, double serviceCharge, double totalBill) {
        super();
        this.cid = cid;
        this.name = name;
        this.currentReading = currentReading;
        this.previousReading = previousReading;
        this.units = units;
        this.serviceCharge = serviceCharge;
        this.totalBill = totalBill;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(int currentReading) {
        this.currentReading = currentReading;
    }

    public int getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(int previousReading) {
        this.previousReading = previousReading;
    }

    // Add setUnits() method
    public void setUnits(int units) {
        this.units = units;
    }

    public int getUnits() {
        return currentReading - previousReading;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "ElectricityBill [cid=" + cid + ", name=" + name + ", currentReading=" + currentReading
                + ", previousReading=" + previousReading + ", units=" + units + ", serviceCharge=" + serviceCharge
                + ", totalBill=" + totalBill + "]";
    }
}
