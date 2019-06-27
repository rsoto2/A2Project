package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Missile extends MovableGameObject implements Movable{
	
private int fuelLevel = 15;
private Ship owner;


public Missile(int color, double x, double y, int speed, int direction, Ship owner) {
	
	super(ColorUtil.BLACK, speed, direction);
	
	this.owner = owner;
	this.getLocation();
	this.setColor(255, 0, 0);
	this.setSpeed(15);
	this.getDirection();
	decrementFuelLevel();
	
	
}

public Missile(int color, double x, double y, int speed, int direction, NonPlayerShip owner) {
	
	super(ColorUtil.BLACK, speed, direction);
	
	this.owner = owner;
	this.getLocation();
	this.setColor(255, 0, 0);
	this.setSpeed(15);
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





public String toString() {
	if(owner instanceof PlayerShip) {
	return ("PS's Missile: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
	" color= " + this.getColorString(getColor()) + 
	" speed= " + this.getSpeed() + 
	" dir= " + this.getDirection() + 
	" fuel= " + this.getFuel());
	}
	else {
		return ("NPS's Missile: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
				" color= " + this.getColorString(getColor()) + 
				" speed= " + Math.round(getSpeed()) + 
				" dir= " + this.getDirection() + 
				" fuel= " + this.getFuel()
				);
	}
}

	
	







}
