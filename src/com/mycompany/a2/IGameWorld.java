package com.mycompany.a2;

public interface IGameWorld {

	int getPlayerScore();
	
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
//
//	public void getElapseTime(int et);
//	
//	public void isSoundEnable(boolean se);
//	
}
