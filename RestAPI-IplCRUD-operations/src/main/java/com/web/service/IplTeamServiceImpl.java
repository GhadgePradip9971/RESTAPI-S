package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.IplTeam;
import com.web.repositiory.IIplTeamRepositiory;


@Service
public class IplTeamServiceImpl implements IIplTeamService {
	
@Autowired
IIplTeamRepositiory iplrepo;

	@Override
	public IplTeam insertData(IplTeam iplTeam) {
		
		return iplrepo.save(iplTeam);
	}

	@Override
	public List<IplTeam> getAllTeams() {
		
		return iplrepo.findAll();
	}

	@Override
	public IplTeam updateTeam(int id, IplTeam iplTeam) {
		// TODO Auto-generated method stub
	IplTeam exitingTeam=	iplrepo.findById(id).get()	;	
		exitingTeam.setName(iplTeam.getName());
		exitingTeam.setTrophyes(iplTeam.getTrophyes());
		exitingTeam.setCaptainName(iplTeam.getCaptainName());
	IplTeam updatedTeam=	iplrepo.save(exitingTeam);
		return updatedTeam;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		IplTeam exitingTeam=	iplrepo.findById(id).get()	;	

		iplrepo.delete(exitingTeam);
		
	}

}
