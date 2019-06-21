package com.mycompany.a2;

import java.util.Iterator;

public interface IGameWorld {

	int getPlayerScore();
	
	int getPlayerLives();
	int getMissileCount();
	
	int getElapseTime();
	
	void addNewAsteroid();
	
	void printMap();
	
	void newSpaceStation();
	
	void newPS();
	
	void newNPS();
	
	void fireMissile();
	
	void launchMissile();
	
	void tick();
	
	void jump ();
	
	void turnPSMLRight();
	
	void turnPSMLLeft();
	
	void turnShipLeft();
	
	void turnShipRight();
	
	void speedUpShip();
	
	void slowUpShip();
	
	void reSupply();
	
	 void playerShipMissileKillAsteroid();
	 
	 void removeMissileAndPS();
	 void removeMissileAndNPS();
	 void removeAstAndPS();
	 void removeNPSAndPS();
	 void removeAstAndNPS();
	 void removeAsteroids();
	 void printDisplay();
	 void setSound(boolean b);
	 boolean getSound();
	 public Iterator getIterator();
//
//	public void getElapseTime(int et);
//	
//	public void isSoundEnable(boolean se);
//	
}
