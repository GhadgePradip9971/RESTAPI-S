package com.web.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

}
