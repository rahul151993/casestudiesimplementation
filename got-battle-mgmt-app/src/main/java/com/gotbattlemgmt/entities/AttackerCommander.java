package com.gotbattlemgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attackercommander")
public class AttackerCommander {
	
	@Id
	@Column(name="attacker_commander_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long acId;
	
	@Column(name="attacker_commander_name")
	private String acName;
	
	@Column(name="battle_number")
	private long battleNumber;

	public long getAcId() {
		return acId;
	}

	public void setAcId(long acId) {
		this.acId = acId;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public long getBattleNumber() {
		return battleNumber;
	}

	public void setBattleNumber(long battleNumber) {
		this.battleNumber = battleNumber;
	}	
}
