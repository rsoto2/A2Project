package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Ship extends MovableGameObject {

	private int missileCount = 10;
	//private MissileLauncher missileLauncher;
	
	public Ship(int color, int speed, int dir) {
		super(ColorUtil.BLACK, 0, 0);
		this.setLocation(512,384);
		//this.setColor(50, 50, 50);
		//this.setDirection(0);
		//this.setSpeed(0);
		getMissileCount();
	}
	
	public void decrementMissile() {
		missileCount--;
	}
	
	
	
	public void setMissileCount(int mC) {
		missileCount = mC;
		
	}
	
	
//	public void setLauncherDirection(MissileLauncher l)
//	{
//		missileLauncher = l;
//	}
//	
//	public int getLauncherDirection()
//	{
//		return missileLauncher.getDirection();
//	}
	
	
	
	public int getMissileCount() {
		return this.missileCount;
	}
	
	
	
}
