package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Missile extends MovableGameObject implements Movable{
	
private int fuelLevel = 15;
private Ship owner;


public Missile(PlayerShip owner) {
	
	super(ColorUtil.BLACK, owner.getSpeed(), owner.getDirection(), owner.getLocationX(), owner.getLocationY());
	
	this.owner = owner;
	//this.getLocation();
	//this.setColor(80, 80, 80);
	this.setSpeed(15);
	//this.getDirection();
	decrementFuelLevel();
	
	
}

public Missile(NonPlayerShip owner) {
	
	super(ColorUtil.BLACK, owner.getSpeed(), owner.getDirection(), owner.getLocationX(), owner.getLocationY());
	
	this.owner = owner;
	//this.getLocation();
	//this.setColor(255, 0, 0);
	//this.setSpeed(15);
	//this.getDirection();
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

@Override
public void draw(Graphics g, Point pCmpRelPrnt ) {
	// TODO Auto-generated method stub
	g.setColor(this.getColor());
	int xLoc = (int) (pCmpRelPrnt.getX() + (int) this.getLocationX());
	int yLoc = (int) (pCmpRelPrnt.getY() + (int) this.getLocationY());
	//int xLoc = (int) ((int) this.getLocationX() + pCmpRelPrnt.getX());// shape location relative
	//int yLoc = (int) ((int) this.getLocationY() + pCmpRelPrnt.getY());// to parents origin
	
	g.fillRect(xLoc, yLoc, 10, 10);
}



	
	







}
