package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Missile extends MovableGameObject implements Movable{
	
private int fuelLevel = 15;
private Ship owner;

public Missile(int color, double x, double y, int speed, int direction, Ship owner) {
	
	super(ColorUtil.BLACK, speed, direction);
	this.owner = owner;
	//this.setLocationX(x);
	//this.setLocationY(y);
	//this.setDirection(direction);
  	//this.setSpeed(30);
    //  this.setLocation(x, y);
  	//this.setDirection(0);
	//this.getDirection();
	//this.getSpeed();
	this.getLocation();
	//this.setLocation(x, y);
	this.setColor(255, 0, 0);
	this.setSpeed(15);
	//this.setDirection(direction);
	this.getDirection();
	decrementFuelLevel();
	
	
}

public Ship getOwner() {
	return this.owner;
}


public void setFuel(int f) {
	fuelLevel = f;
}

public int getFuel() {
	return this.fuelLevel;
}

public int decrementFuelLevel() {
	super.move();
	return fuelLevel--;
	//return this.getFuel() - 1;
}





public String missileString(boolean x) {
	if(x == true) {
	return ("PS's Missile: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
	" color= " + GameObject.getColorString(getColor()) + 
	" speed= " + Math.round(getSpeed()) + 
	" dir= " + getDirection() + 
	" fuel= " + getFuel());
	}else {
		return ("NPS's Missile: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
				" color= " + GameObject.getColorString(getColor()) + 
				" speed= " + Math.round(getSpeed()) + 
				" dir= " + getDirection() + 
				" fuel= " + getFuel()
				);
	}
}

	
	







}
