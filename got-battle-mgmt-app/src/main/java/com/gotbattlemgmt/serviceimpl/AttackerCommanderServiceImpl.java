package com.gotbattlemgmt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotbattlemgmt.repository.AttackerCommanderRepository;
import com.gotbattlemgmt.service.AttackerCommanderService;

@Service
public class AttackerCommanderServiceImpl implements AttackerCommanderService{
	
	@Autowired
	private AttackerCommanderRepository attackerCommanderRepository;
}
