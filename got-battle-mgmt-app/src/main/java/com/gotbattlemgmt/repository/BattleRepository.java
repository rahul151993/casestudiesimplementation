package com.gotbattlemgmt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotbattlemgmt.entities.Battle;

@Repository
public interface BattleRepository extends CrudRepository<Battle, Long>{

	@Query(value="select b.region, l.locationName from Battle b, Location l where b.battleNumber=l.battleNumber")
	public Object[] getPlaces();

	@Query(value="select b.region, l.locationName from Battle b, Location l where b.battleNumber=:battleNo and b.battleNumber=l.battleNumber")
	public Object[] getPlacesByBattleNo(@Param("battleNo")long battleNo);
}
