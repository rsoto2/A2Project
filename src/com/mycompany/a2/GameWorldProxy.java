package com.mycompany.a2;

import java.util.Iterator;
import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {

	
	private GameWorld gw;
	
	
	public GameWorldProxy(GameWorld gw)
	{
		
		this.gw = gw;
		
	}
	
	
	
	
	
	
	
	
	@Override
	public int getPlayerScore() {
		// TODO Auto-generated method stub
		return gw.getPlayerScore();
	}






	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return gw.getMissileCount();
	}






	@Override
	public int getElapseTime() {
		// TODO Auto-generated method stub
		return gw.getElapseTime();
	}








	@Override
	public void addNewAsteroid() {
		// TODO Auto-generated method stub
		gw.addNewAsteroid();
	}








	@Override
	public void printMap() {
		// TODO Auto-generated method stub
		gw.printMap();
		
	}








	@Override
	public void newSpaceStation() {
		// TODO Auto-generated method stub
		gw.newSpaceStation();
		
		
	}








	@Override
	public void newPS() {
		// TODO Auto-generated method stub
		gw.newNPS();
		
	}








	@Override
	public void newNPS() {
		// TODO Auto-generated method stub
		gw.newNPS();
		
	}








	@Override
	public void fireMissile() {
		// TODO Auto-generated method stub
		gw.fireMissile();
		
	}








	@Override
	public void launchMissile() {
		// TODO Auto-generated method stub
		gw.launchMissile();
		
	}








	@Override
	public void tick() {
		// TODO Auto-generated method stub
		gw.tick();
		
	}








	@Override
	public void jump() {
		// TODO Auto-generated method stub
		gw.jump();
		
	}








	@Override
	public void turnPSMLRight() {
		// TODO Auto-generated method stub
		gw.turnPSMLRight();
		
	}








	@Override
	public void turnPSMLLeft() {
		// TODO Auto-generated method stub
		gw.turnPSMLLeft();
		
	}








	@Override
	public void turnShipLeft() {
		// TODO Auto-generated method stub
		gw.turnShipLeft();
	}








	@Override
	public void turnShipRight() {
		// TODO Auto-generated method stub
		gw.turnShipRight();
		
	}








	@Override
	public void speedUpShip() {
		// TODO Auto-generated method stub
		gw.speedUpShip();
		
	}








	@Override
	public void slowUpShip() {
		// TODO Auto-generated method stub
		gw.slowUpShip();
		
	}








	@Override
	public void reSupply() {
		// TODO Auto-generated method stub
		gw.reSupply();
		
	}








	@Override
	public void playerShipMissileKillAsteroid() {
		// TODO Auto-generated method stub
		gw.playerShipMissileKillAsteroid();
		
	}








	@Override
	public void removeMissileAndPS() {
		// TODO Auto-generated method stub
		gw.removeMissileAndPS();
		
	}








	@Override
	public void removeMissileAndNPS() {
		// TODO Auto-generated method stub
		gw.removeMissileAndNPS();
		
	}








	@Override
	public void removeAstAndPS() {
		// TODO Auto-generated method stub
		gw.removeAstAndPS();
		
	}








	@Override
	public void removeNPSAndPS() {
		// TODO Auto-generated method stub
		gw.removeNPSAndPS();
		
	}








	@Override
	public void removeAstAndNPS() {
		// TODO Auto-generated method stub
		gw.removeAstAndNPS();
		
	}








	@Override
	public void removeAsteroids() {
		// TODO Auto-generated method stub
		gw.removeAsteroids();
		
	}








	@Override
	public void printDisplay() {
		// TODO Auto-generated method stub
		gw.printDisplay();
		
	}








	@Override
	public void setSound(boolean s) {
		// TODO Auto-generated method stub
		gw.setSound(s);
		
	}








	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return gw.getIterator();
	}








	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return gw.getSound();
	}








	@Override
	public int getPlayerLives() {
		// TODO Auto-generated method stub
		return gw.getPlayerLives();
	}



}
