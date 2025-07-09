package com.web.service;

import java.util.List;
import com.web.model.ElectricityBill;

public interface ElectricityService {
    
    // Save a new bill
    public ElectricityBill saveBill(ElectricityBill electricityBill);

    // Update an existing bill based on CID
    public ElectricityBill updateBill(ElectricityBill electricityBill, int cid);

    // Get a single bill by CID
    public ElectricityBill getOneBill(int cid);

    // Delete a bill by CID
    public void deleteBill(int cid);

    // Get all bills
    public List<ElectricityBill> getAllBills();
}
