package com.gotbattlemgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@Column(name="location_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long locId;
	
	@Column(name="location_name")
	private String locationName;
	
	@Column(name="battle_number")
	private long battleNumber;

	public long getLocId() {
		return locId;
	}

	public void setLocId(long locId) {
		this.locId = locId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public long getBattleNumber() {
		return battleNumber;
	}

	public void setBattleNumber(long battleNumber) {
		this.battleNumber = battleNumber;
	}
}
