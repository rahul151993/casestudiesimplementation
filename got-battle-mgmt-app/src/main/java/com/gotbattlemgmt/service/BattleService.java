package com.gotbattlemgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gotbattlemgmt.entities.Battle;
import com.gotbattlemgmt.model.BattleCount;
import com.gotbattlemgmt.model.BattlePlace;

@Service
public interface BattleService {

	public Battle createBattle(Battle battle);

	public Iterable<Battle> getAllBattles();

	public List<BattlePlace> getBattlePlaces();

	public BattleCount getBattlesCount();

	public Battle getBattleByBattleNumber(long battleNo);

	public List<BattlePlace> getBattlePlacesByBattleNo(long battleNo);
}
