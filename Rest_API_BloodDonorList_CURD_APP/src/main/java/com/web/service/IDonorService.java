package com.web.service;

import java.util.List;

import com.web.entity.Donor;

public interface IDonorService {
	
	
	Donor addDonor(Donor donor);
	List<Donor> getAllDonor();
	Donor getDonorById(Long id);
	Donor updateDononr(Long id,Donor donor);
	void deleteDonor(Long id);
	

}
