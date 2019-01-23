package com.gotbattlemgmt.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gotbattlemgmt.constants.Constants;
import com.gotbattlemgmt.entities.Attacker;
import com.gotbattlemgmt.entities.AttackerCommander;
import com.gotbattlemgmt.entities.Battle;
import com.gotbattlemgmt.entities.Defender;
import com.gotbattlemgmt.entities.DefenderCommander;
import com.gotbattlemgmt.entities.Location;
import com.gotbattlemgmt.exception.EmptyFieldException;
import com.gotbattlemgmt.repository.BattleRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.gotbattlemgmt")
@EntityScan(basePackages="com.gotbattlemgmt.entities")
@EnableJpaRepositories(basePackages="com.gotbattlemgmt.repository")
public class GotBattleManagementApp {

	private static BattleRepository battleRepository = null;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(GotBattleManagementApp.class, args);
		battleRepository = applicationContext.getBean("battleRepository", BattleRepository.class);
		readCsvFile();
	}
	
	private static void readCsvFile() {
		File file = new File("battles (4) (2).csv");
		try {
			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine();
			String[] headings = line.split(",");
			ArrayList<String> listOfHeadings = new ArrayList<String>();
			for(int i=0;i<headings.length;i++) {
				listOfHeadings.add(headings[i].trim());
			}
			while(scanner.hasNext()) {
				LinkedHashMap<String,String> record = new LinkedHashMap();
				line = scanner.nextLine();
				System.out.println(line);
				String[] elements = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				for(int i=0;i<elements.length;i++) {
					String element = elements[i].trim();
						record.put(listOfHeadings.get(i),element);
				}
				Battle battle = new Battle();
				Set<String> keys = record.keySet();
				for(String key : keys) {
					if(Constants.ATTACKER_1.equals(key)||Constants.ATTACKER_2.equals(key)||Constants.ATTACKER_3.equals(key)||Constants.ATTACKER_4.equals(key)) {
						String value = record.get(key);
						if(!("").equals(value)) {
							Attacker attacker = new Attacker();
							attacker.setAttackerName(value.trim());
							battle.getAttackerList().add(attacker);
						}
					}
					
					if(Constants.DEFENDER_1.equals(key)||Constants.DEFENDER_2.equals(key)||Constants.DEFENDER_3.equals(key)||Constants.DEFENDER_4.equals(key)) {
						String value = record.get(key);
						if(!("").equals(value)) {
							Defender defender = new Defender();
							defender.setDefenderName(value.trim());
							battle.getDefenderList().add(defender);							
						}
					}
					
					if(Constants.ATTACKER_COMMANDER.equals(key)) {
						String value  = record.get(key);
						if(!("").equals(value)) {
							value = value.replaceAll("\"", "");
							String[] values = value.split(",");
							for(int i=0;i<values.length;i++) {
								String acName = values[i].trim();
								AttackerCommander attackerCommander = new AttackerCommander();
								attackerCommander.setAcName(acName);
								battle.getAttackerCommanderList().add(attackerCommander);
							}
							
						}
					}
					
					if(Constants.DEFENDER_COMMANDER.equals(key)) {
						String value  = record.get(key);
						if(!("").equals(value)) {
							value = value.replaceAll("\"", "");
							String[] values = value.split(",");
							for(int i=0;i<values.length;i++) {
								String dcName = values[i].trim();
								DefenderCommander defenderCommander = new DefenderCommander();
								defenderCommander.setDcName(dcName);
								battle.getDefenderCommanderList().add(defenderCommander);
							}
						}
					}
					
					if(Constants.LOCATION.equals(key)) {
						String value  = record.get(key);
						if(!("").equals(value)) {
							value = value.replaceAll("\"", "");
							String[] values = value.split(",");
							for(int i=0;i<values.length;i++) {
								String locationName = values[i].trim();
								Location location = new Location();
								location.setLocationName(locationName);
								battle.getLocationList().add(location);
							}
						}
					}
				}
				
				String name = record.get(Constants.NAME);
				String year = record.get(Constants.YEAR);
				String attackerKing = record.get(Constants.ATTACKER_KING);
				String defenderKing = record.get(Constants.DEFENDER_KING);
				String attackerOutcomes = record.get(Constants.ATTACKER_OUTCOMES);
				String battleType = record.get(Constants.BattleType);
				String majorDeath = record.get(Constants.MAJOR_DEATH);
				String majorCapture = record.get(Constants.MAJOR_Capture);
				String attackerSize = record.get(Constants.ATTACKER_SIZE);
				String defenderSize = record.get(Constants.DEFENDER_SIZE);
				String summer = record.get(Constants.SUMMER);
				String region  = record.get(Constants.REGION);
				String note = record.get(Constants.NOTE);
				
				if(!("").equals(name)) {
					battle.setName(name.trim());
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(name)) {
					battle.setYear(Integer.parseInt(year.trim()));
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(attackerKing)) {
					battle.setAttackerKing(attackerKing.trim());
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(defenderKing)) {
					battle.setDefenderKing(defenderKing.trim());
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(attackerOutcomes)) {
					battle.setAttackerOutcomes(attackerOutcomes.trim());
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(battleType)) {
					battle.setBattleType(battleType.trim());
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(majorDeath)) {
					battle.setMajorDeath(Integer.parseInt(majorDeath.trim()));
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(majorCapture)) {
					battle.setMajorCapture(Integer.parseInt(majorCapture.trim()));
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(attackerSize)) {
					battle.setAttackerSize(Integer.parseInt(attackerSize.trim()));
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(defenderSize)) {
					battle.setDefenderSize(Integer.parseInt(defenderSize.trim()));
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(summer)) {
					battle.setSummer(Integer.parseInt(summer.trim()));
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(region)) {
					battle.setRegion(region.trim());
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
				
				if(!("").equals(note)) {
					note = note.replaceAll("\"", "");
					battle.setNote(note);
				}
				else {
					try {
						throw new EmptyFieldException(Constants.EmptyFieldExceptionMessage);
					} catch (EmptyFieldException e) {
						System.out.println(e.getMessage());
					}
				}
				
			//save the battle
				battleRepository.save(battle);
			}
			scanner.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
