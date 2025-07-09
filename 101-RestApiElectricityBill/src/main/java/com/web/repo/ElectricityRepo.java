package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.ElectricityBill;
@Repository
public interface ElectricityRepo extends JpaRepository<ElectricityBill, Integer> {

}
