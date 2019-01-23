package com.gotbattlemgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="defendercommander")
public class DefenderCommander {
	
	@Id
	@Column(name="defender_commander_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long dcId;
	
	@Column(name="defender_commander_name")
	private String dcName;
	
	@Column(name="battle_number")
	private long battleNumber;

	public long getDcId() {
		return dcId;
	}

	public void setDcId(long dcId) {
		this.dcId = dcId;
	}

	public String getDcName() {
		return dcName;
	}

	public void setDcName(String dcName) {
		this.dcName = dcName;
	}

	public long getBattleNumber() {
		return battleNumber;
	}

	public void setBattleNumber(long battleNumber) {
		this.battleNumber = battleNumber;
	}	
}
