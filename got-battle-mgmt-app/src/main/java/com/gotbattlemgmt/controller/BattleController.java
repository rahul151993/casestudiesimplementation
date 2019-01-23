package com.gotbattlemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotbattlemgmt.entities.Battle;
import com.gotbattlemgmt.model.BattleCount;
import com.gotbattlemgmt.model.BattlePlace;
import com.gotbattlemgmt.service.BattleService;

@RestController
@RequestMapping(value="/api/battle")
public class BattleController {
	
	@Autowired
	private BattleService battleService;
	
	@PostMapping(value="/addbattle")
	public Battle createBattle(@RequestBody Battle battle){		
		return battleService.createBattle(battle);
	}
	
	@GetMapping(value="/getallbattles")
	public Iterable<Battle> getAllBattles(){
		return battleService.getAllBattles();
	}
	
	@GetMapping(value="/list")
	public List<BattlePlace> getBattlePlaces() {
		return battleService.getBattlePlaces();
	}
	
	@GetMapping(value="/count")
	public BattleCount getCountofBattles() {
		return battleService.getBattlesCount();
	}
	
	@GetMapping(value="/getbattle/{battleNo}")
	public Battle getSpecificBattleByBattleNumber(@PathVariable("battleNo")long battleNo) {
		return battleService.getBattleByBattleNumber(battleNo);
	}
	
	@GetMapping(value="/list/{battleNo}")
	public List<BattlePlace> getBattlePlaces(@PathVariable("battleNo")long battleNo) {
		return battleService.getBattlePlacesByBattleNo(battleNo);
	}
 }
