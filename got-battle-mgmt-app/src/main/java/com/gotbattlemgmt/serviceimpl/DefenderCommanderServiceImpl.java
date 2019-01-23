package com.gotbattlemgmt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotbattlemgmt.repository.DefenderCommanderRepository;
import com.gotbattlemgmt.repository.DefenderRepository;
import com.gotbattlemgmt.service.DefenderCommanderService;

@Service
public class DefenderCommanderServiceImpl implements DefenderCommanderService{
	
	@Autowired
	private DefenderCommanderRepository defenderCommanderRepository;
}
