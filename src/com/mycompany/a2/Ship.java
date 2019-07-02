package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Ship extends MovableGameObject {

	
	
	public Ship(int color, int speed, int dir, double x, double y) {
		super(color, speed, dir, x, y);
		//this.setLocation(512,384);
		//this.setColor(50, 50, 50);
		//this.setDirection(0);
		//this.setSpeed(0);
		//getMissileCount();
		
	}
	
	public Ship(int color)
	{
		super(color);
	}
	
	


	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		int xLoc = (int) (pCmpRelPrnt.getX() + (int) this.getLocationX());
		int yLoc = (int) (pCmpRelPrnt.getY() + (int) this.getLocationY());
		//int xLoc = (int) ((int) this.getLocationX() + pCmpRelPrnt.getX());// shape location relative
		//int yLoc = (int) ((int) this.getLocationY() + pCmpRelPrnt.getY());// to parents origin
		
		g.fillRect(xLoc, yLoc, 10, 10);
		
	}


	
	
	
}
