package com.gotbattlemgmt.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="battle")
public class Battle {
	@Id
	@Column(name="battle_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long battleNumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year")
	private int year;
	
	@Column(name="attacker_king")
	private String attackerKing;
	
	@Column(name="defender_king")
	private String defenderKing;
	
	@Column(name="attacker_outcomes")
	private String attackerOutcomes;
	
	@Column(name="battle_type")
	private String battleType;
	
	@Column(name="major_death")
	private int majorDeath;
	
	@Column(name="major_capture")
	private int majorCapture;
	
	@Column(name="attacker_size")
	private int attackerSize;
	
	@Column(name="defender_size")
	private int defenderSize;
	
	@Column(name="summer")
	private int summer;
	
	@Column(name="region")
	private String region;
	
	@Column(name="note",length=1500)
	private String note;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="battle_number",referencedColumnName="battle_number")
	private List<Attacker> attackerList = new ArrayList<Attacker>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="battle_number",referencedColumnName="battle_number")
	private List<AttackerCommander> attackerCommanderList = new ArrayList<AttackerCommander>();
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="battle_number",referencedColumnName="battle_number")
	private List<Defender> defenderList = new ArrayList<Defender>();
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="battle_number",referencedColumnName="battle_number")
	private List<DefenderCommander> defenderCommanderList = new ArrayList<DefenderCommander>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="battle_number",referencedColumnName="battle_number")
	private List<Location> locationList = new ArrayList<Location>();	

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public List<DefenderCommander> getDefenderCommanderList() {
		return defenderCommanderList;
	}

	public void setDefenderCommanderList(List<DefenderCommander> defenderCommanderList) {
		this.defenderCommanderList = defenderCommanderList;
	}

	public List<Defender> getDefenderList() {
		return defenderList;
	}

	public void setDefenderList(List<Defender> defenderList) {
		this.defenderList = defenderList;
	}

	public List<AttackerCommander> getAttackerCommanderList() {
		return attackerCommanderList;
	}

	public void setAttackerCommanderList(List<AttackerCommander> attackerCommanderList) {
		this.attackerCommanderList = attackerCommanderList;
	}

	public List<Attacker> getAttackerList() {
		return attackerList;
	}

	public void setAttackerList(List<Attacker> attackerList) {
		this.attackerList = attackerList;
	}

	public long getBattleNumber() {
		return battleNumber;
	}

	public void setBattleNumber(long battleNumber) {
		this.battleNumber = battleNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAttackerKing() {
		return attackerKing;
	}

	public void setAttackerKing(String attackerKing) {
		this.attackerKing = attackerKing;
	}

	public String getDefenderKing() {
		return defenderKing;
	}

	public void setDefenderKing(String defenderKing) {
		this.defenderKing = defenderKing;
	}

	public String getAttackerOutcomes() {
		return attackerOutcomes;
	}

	public void setAttackerOutcomes(String attackerOutcomes) {
		this.attackerOutcomes = attackerOutcomes;
	}

	public String getBattleType() {
		return battleType;
	}

	public void setBattleType(String battleType) {
		this.battleType = battleType;
	}

	public int getMajorDeath() {
		return majorDeath;
	}

	public void setMajorDeath(int majorDeath) {
		this.majorDeath = majorDeath;
	}

	public int getMajorCapture() {
		return majorCapture;
	}

	public void setMajorCapture(int majorCapture) {
		this.majorCapture = majorCapture;
	}

	public int getAttackerSize() {
		return attackerSize;
	}

	public void setAttackerSize(int attackerSize) {
		this.attackerSize = attackerSize;
	}

	public int getDefenderSize() {
		return defenderSize;
	}

	public void setDefenderSize(int defenderSize) {
		this.defenderSize = defenderSize;
	}

	public int getSummer() {
		return summer;
	}

	public void setSummer(int summer) {
		this.summer = summer;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
