package com.web.service;

import org.apache.el.stream.Optional;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.exception.TouristNotFoundException;
import com.web.model.Tourist;
import com.web.repositiory.ITouristRepo;

@Service("touristService")
public class TouristMgmServiceImpl implements ITouristMgmService {
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		
		int idVal=touristRepo.save(tourist).getTid();
		return "Tourist Is Registerd With Id="+idVal;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		// TODO Auto-generated method stub
		List<Tourist> list=touristRepo.findAll();
		//list.sort(t1,t2)->t1.get;
		return list ;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		// TODO Auto-generated method stub
		
		
		return touristRepo.findById(tid).orElseThrow(()-> new TouristNotFoundException(tid+" Tourist is Not Found with this id"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		// TODO Auto-generated method stub
		Optional<Tourist> optional=touristRepo.findById(tourist.getTid());
		if(optional.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid()+" Tourist got updated with this id";
		}
		else {
			throw new TouristNotFoundException(tourist.getTid()+" Tourist is not found with this id");
		}
	}

	@Override
	public String deleteTourist(Integer tid) throws TouristNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Tourist> opt=touristRepo.findById(tid);
		if(opt.isPresent()) {
			touristRepo.delete(opt.get());
			return tid+" Tourist deleted with this id";
		}
		else {
			throw new TouristNotFoundException(tid+" Tourist Not found With this Id");
		}
	}

	@Override
	public String updateTouristBudgetBYId(Integer tid, Double hikePercent) throws TouristNotFoundException {
		// TODO Auto-generated method stub
		Optional<Tourist> tour=touristRepo.findById(tid);
		if(tour.isPresent()) {
			
			Tourist tourist=tour.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercent/100)));
			touristRepo.save(tourist);
			return "Tourist Budget is updated";
			
		}
		else {
			throw new TouristNotFoundException(tid+" Tourist is not found with this tid");
			
		}
	}

}
