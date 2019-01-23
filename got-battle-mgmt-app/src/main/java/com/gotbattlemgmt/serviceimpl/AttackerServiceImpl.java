package com.gotbattlemgmt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotbattlemgmt.repository.AttackerRepository;
import com.gotbattlemgmt.service.AttackerService;

@Service
public class AttackerServiceImpl implements AttackerService{
	
	@Autowired
	private AttackerRepository attackerRepository;
}
