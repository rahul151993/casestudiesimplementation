package com.gotbattlemgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="defender")
public class Defender {
	
	@Id
	@Column(name="defender_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long defenderId;
	
	@Column(name="defender_name")
	private String defenderName;
	
	@Column(name="battle_number")
	private long battleNumber;

	public long getDefenderId() {
		return defenderId;
	}

	public void setDefenderId(long defenderId) {
		this.defenderId = defenderId;
	}

	public String getDefenderName() {
		return defenderName;
	}

	public void setDefenderName(String defenderName) {
		this.defenderName = defenderName;
	}

	public long getBattleNumber() {
		return battleNumber;
	}

	public void setBattleNumber(long battleNumber) {
		this.battleNumber = battleNumber;
	}
}
