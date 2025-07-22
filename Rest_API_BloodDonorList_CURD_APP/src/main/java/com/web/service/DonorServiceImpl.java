package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.web.entity.Donor;
import com.web.exception.DonorNotFoundException;
import com.web.repositiory.DonorRepository;

@Service
public class DonorServiceImpl implements IDonorService {
	
	@Autowired
	private DonorRepository donorrepo;

	@Override
	public Donor addDonor(Donor donor) {
		// TODO Auto-generated method stub
		return donorrepo.save(donor);
	}

	@Override
	public List<Donor> getAllDonor() {
		// TODO Auto-generated method stub
		
	
		return donorrepo.findAll();
	}

	@Override
	public Donor getDonorById(Long id) {
		// TODO Auto-generated method stub
		if(!donorrepo.existsById(id)) {
			throw new DonorNotFoundException("Donor Not Found with id:"+id);
			
		}
		return donorrepo.findById(id).get();
	}

	@Override
	public Donor updateDononr(Long id, Donor donor) {
		// TODO Auto-generated method stub
		
		Optional<Donor> d=donorrepo.findById(id);
	if(d.isPresent()) {
		
		Donor existedDonor=d.get();
		
	existedDonor.setName(donor.getName());
	existedDonor.setAge(donor.getAge());
existedDonor.setBloodgroup(donor.getBloodgroup());

return donorrepo.save(existedDonor);
	
	}
	else {
		throw new DonorNotFoundException("Donor Not Found with id:"+id);
		
	}
		
	}
	
	

	@Override
	public void deleteDonor(Long id) {
	    Optional<Donor> d = donorrepo.findById(id);
	    if (d.isPresent()) {
	        donorrepo.deleteById(id);
	    } else {
	        throw new DonorNotFoundException("Donor Not Found with id: " + id);
	    }
	}

	
	
	

}
