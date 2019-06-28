package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

public class NonSteerableMissile extends MovableGameObject implements Movable {
private NonPlayerShip owner;
	
	public NonSteerableMissile(NonPlayerShip owner , int objectColor, int speed, int direction, double x, double y) {
		super(objectColor, speed, direction, x, y);
		this.getLocation();
		this.setColor(255, 0, 0);
		this.setSpeed(15);
		this.getDirection();
		this.owner = owner;
	}

	@Override
	public void move() {
		this.setLocation(owner.getLocationX(), owner.getLocationY());	
	}

	@Override
	public void draw(Graphics g,  Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		int xLoc = (int) ((int) this.getLocationX() + pCmpRelPrnt.getX());// shape location relative
		int yLoc = (int) ((int) this.getLocationY() + pCmpRelPrnt.getY());// to parents origin
		
		g.fillRect(xLoc, yLoc, 10, 10);
	}


}
