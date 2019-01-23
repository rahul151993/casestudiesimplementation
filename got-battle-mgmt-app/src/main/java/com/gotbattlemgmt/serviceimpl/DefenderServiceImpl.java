package com.gotbattlemgmt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotbattlemgmt.repository.DefenderRepository;
import com.gotbattlemgmt.service.DefenderService;

@Service
public class DefenderServiceImpl implements DefenderService{
	
	@Autowired
	private DefenderRepository defenderRepository; 
}
