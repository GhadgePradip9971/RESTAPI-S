package com.web.service;



import java.util.List;

import com.web.exception.TouristNotFoundException;
import com.web.model.Tourist;

public interface ITouristMgmService {
	
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
    public String deleteTourist(Integer tid) throws TouristNotFoundException;
    public String updateTouristBudgetBYId(Integer tid,Double hikePercent) throws TouristNotFoundException;
}
