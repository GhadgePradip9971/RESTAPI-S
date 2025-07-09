package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ElectricityBill;
import com.web.service.ElectricityService;

@RestController
@CrossOrigin(origins = {"*"})
public class ElectricityBillController {
    
    @Autowired
    private ElectricityService service;  // Use ElectricityService instead of ElectricityBillImp
    
    @PostMapping("/save")
    public String saveBillData(@RequestBody ElectricityBill electricityBill) {
        ElectricityBill saveData = service.saveBill(electricityBill);
        
        String message = null;
        if (saveData != null) {
            message = "Data saved successfully";
        } else {
            message = "Data save failed";
        }
        return message;
    }
    
    @GetMapping("/getone/{cid}")
    public ElectricityBill getoneConsumerRecord(@PathVariable int cid) {
        return service.getOneBill(cid);
    }

    @GetMapping("/getAll")
    public List<ElectricityBill> getAllConsumers() {
        return service.getAllBills();
    }
    
    @DeleteMapping("/delete/{cid}")
    public String delete(@PathVariable int cid) {
        // Call the service method to delete the bill
        service.deleteBill(cid);
        
        // Return a confirmation message
        return "Data with consumer ID " + cid + " deleted successfully";
    }


    @PutMapping("/update/{cid}")
    public String updateConsumer(@RequestBody ElectricityBill electricityBill, @PathVariable int cid) {
        // Call the service method to update the bill
        ElectricityBill updatedBill = service.updateBill(electricityBill, cid);
        
        // Return a confirmation message including the updated data
        return "Data with consumer ID " + cid + " and updated bill: " + updatedBill + " updated successfully";
    }

}
