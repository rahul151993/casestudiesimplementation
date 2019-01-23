package com.gotbattlemgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attacker")
public class Attacker {
	
	@Id
	@Column(name="attacker_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long attackerId;
	
	@Column(name="attacker_name")
	private String attackerName;
	
	@Column(name="battle_number")
	private long battleNumber;

	public long getAttackerId() {
		return attackerId;
	}

	public void setAttackerId(long attackerId) {
		this.attackerId = attackerId;
	}

	public String getAttackerName() {
		return attackerName;
	}

	public void setAttackerName(String attackerName) {
		this.attackerName = attackerName;
	}

	public long getBattleNumber() {
		return battleNumber;
	}

	public void setBattleNumber(long battleNumber) {
		this.battleNumber = battleNumber;
	}
}
