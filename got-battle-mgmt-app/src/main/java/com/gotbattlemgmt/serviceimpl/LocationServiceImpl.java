package com.gotbattlemgmt.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotbattlemgmt.repository.LocationRepository;
import com.gotbattlemgmt.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private LocationRepository locationRepository;
}
