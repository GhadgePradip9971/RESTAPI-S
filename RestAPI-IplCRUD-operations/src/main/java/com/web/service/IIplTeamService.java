package com.web.service;

import java.util.List;

import com.web.model.IplTeam;

public interface IIplTeamService {
	public IplTeam insertData(IplTeam iplTeam);
	public List<IplTeam> getAllTeams();
	public IplTeam updateTeam(int id, IplTeam iplTeam);
	public void delete(int id);
	
	

}
