package com.gotbattlemgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gotbattlemgmt.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
}
