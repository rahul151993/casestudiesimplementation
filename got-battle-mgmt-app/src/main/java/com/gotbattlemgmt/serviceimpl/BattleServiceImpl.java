package com.gotbattlemgmt.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotbattlemgmt.entities.Battle;
import com.gotbattlemgmt.model.BattleCount;
import com.gotbattlemgmt.model.BattlePlace;
import com.gotbattlemgmt.repository.BattleRepository;
import com.gotbattlemgmt.service.BattleService;

@Service
public class BattleServiceImpl implements BattleService{
	
	@Autowired
	private BattleRepository battleRepository;
	
	@Override
	public Battle createBattle(Battle battle) {
		return battleRepository.save(battle);
	}
	
	@Override
	public Iterable<Battle> getAllBattles() {
		return battleRepository.findAll();
	}
	
	@Override
	public List<BattlePlace> getBattlePlaces() {
		Object[] objArray =  battleRepository.getPlaces();
		List<BattlePlace> battlePlaces = new ArrayList<BattlePlace>();
		for(int i=0;i<objArray.length;i++) {
			Object[] obj = (Object[]) objArray[i];
			BattlePlace battlePlace = new BattlePlace();
			for(int j=0;j<obj.length;j++) {
				String region = (String)obj[0];
				String location = (String)obj[1];
				battlePlace.setRegion(region);
				battlePlace.setLocationName(location);
			}
			battlePlaces.add(battlePlace);
		}
		return battlePlaces;
	}
	
	@Override
	public BattleCount getBattlesCount() {
		
		long bCount = battleRepository.count();
		BattleCount battleCount = new BattleCount();
		battleCount.setBattleCount(bCount);
		return battleCount;
	}
	
	@Override
	public Battle getBattleByBattleNumber(long battleNo) {
		return battleRepository.findById(battleNo).get();
	}
	
	@Override
	public List<BattlePlace> getBattlePlacesByBattleNo(long battleNo) {
		Object[] objArray =  battleRepository.getPlacesByBattleNo(battleNo);
		List<BattlePlace> battlePlaces = new ArrayList<BattlePlace>();
		for(int i=0;i<objArray.length;i++) {
			Object[] obj = (Object[]) objArray[i];
			BattlePlace battlePlace = new BattlePlace();
			for(int j=0;j<obj.length;j++) {
				String region = (String)obj[0];
				String location = (String)obj[1];
				battlePlace.setRegion(region);
				battlePlace.setLocationName(location);
			}
			battlePlaces.add(battlePlace);
		}
		return battlePlaces;
	}
}
