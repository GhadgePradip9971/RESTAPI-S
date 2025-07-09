package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.ElectricityBill;
import com.web.repo.ElectricityRepo;

@Service
public class ElectricityBillImp implements ElectricityService {

    @Autowired
    private ElectricityRepo repo;

    @Override
    public ElectricityBill saveBill(ElectricityBill electricityBill) {
        // Calculate units, service charge, and total bill before saving
        int units = electricityBill.getCurrentReading() - electricityBill.getPreviousReading();
        double serviceCharge = 120.00;
        double totalBill = 0.0;

        if (units < 300) {
            totalBill = units * 1.75;
        } else if (units >= 300 && units < 700) {
            totalBill = units * 3.75;
        } else if (units >= 700) {
            totalBill = units * 9.75;
        }

        electricityBill.setUnits(units);
        electricityBill.setTotalBill(totalBill);
        electricityBill.setServiceCharge(serviceCharge);
        
        return repo.save(electricityBill);
    }

    @Override
    public ElectricityBill getOneBill(int cid) {
        return repo.findById(cid).orElse(null);
    }

    @Override
    public void deleteBill(int cid) {
        repo.deleteById(cid);
    }

    @Override
    public List<ElectricityBill> getAllBills() {
        return repo.findAll();
    }

    @Override
    public ElectricityBill updateBill(ElectricityBill electricityBill, int cid) {
        // Retrieve the existing record
        ElectricityBill oldRecord = repo.findById(cid).orElseThrow(() -> new RuntimeException("Bill not found"));

        // Recalculate units, service charge, and total bill
        int units = electricityBill.getCurrentReading() - electricityBill.getPreviousReading();
        double serviceCharge = 299.00; // New service charge for updates
        double totalBill = 0.0;

        if (units < 300) {
            totalBill = units * 2.75;
        } else if (units >= 300 && units < 700) {
            totalBill = units * 4.75;
        } else if (units >= 700) {
            totalBill = units * 6.75;
        }

        // Update the old record with the new values
        oldRecord.setName(electricityBill.getName());
        oldRecord.setCurrentReading(electricityBill.getCurrentReading());
        oldRecord.setPreviousReading(electricityBill.getPreviousReading());
        oldRecord.setUnits(units);
        oldRecord.setServiceCharge(serviceCharge);
        oldRecord.setTotalBill(totalBill);

        return repo.save(oldRecord);
    }
}
