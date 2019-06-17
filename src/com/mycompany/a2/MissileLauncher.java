package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class MissileLauncher extends MovableGameObject implements ISteerable {

	public MissileLauncher(double x, double y, int speed, int direction)
	{
		super(ColorUtil.GRAY, 0, 0);
		this.getLocationX();
		this.getLocationY();
		//this.getDirection();
		//this.setDirection(direction);
		this.setSpeed(speed);
		
		this.setDirection(0);
		
		
	}
	
	
	public String toString() {
		return "Player MissileLauncher: " + getDirection();
	}
	
	public int getMissileLauncherDirection() {
		return getDirection();
	}
	
	public void setMissileLauncherDirection(int amount) {
		setDirection(amount);
	}

//	@Override
//	public void turnLeft() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void turnRight() {
//		// TODO Auto-generated method stub
//		
//	}


	@Override
	public void Steer(int amount) {
		// TODO Auto-generated method stub
		setDirection(getDirection() + amount);
		
	}
	

	
	
	
}
