package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class MissileLauncher extends MovableGameObject implements ISteerable, IDrawable, Movable {

	private PlayerShip owner;
	private int direction;
	private int amount;
	
	
	public MissileLauncher(double x, double y, int speed, int direction, PlayerShip owner)
	{
		super(ColorUtil.GRAY, speed, direction, x, y);
		//this.getLocationX();
		//this.getLocationY();
		this.owner = owner;
		//super.setLocation(x, y);
		
		this.amount = 15;
		
	}
	
	
	public String toString() {
		return "Player MissileLauncher: " + getDirection();
	}

	
	public void setOwner(PlayerShip ps)
	{
		owner = ps;
	}
	
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
	
	public int getDirection()
	{
		return this.direction;
	}
	
	
	public void Steer(int amount) {
	if(getDirection() == 0 && amount < 0) 
	{
		setDirection(359);
	}
	else 
	{
		setDirection(getDirection() + amount);
	}
	
	}
	public void move(){
		this.setLocation(owner.getLocationX(), owner.getLocationY());
	}
	
	
	  @Override 
	  public void draw(Graphics g,  Point pCmpRelPrnt) { // TODO Auto-generated method stub
		  g.setColor(this.getColor());
			int xLoc = (int) ((int) this.getLocationX() + pCmpRelPrnt.getX());// shape location relative
			int yLoc = (int) ((int) this.getLocationY() + pCmpRelPrnt.getY());// to parents origin
			
			g.drawLine(xLoc, yLoc, 10, 10);
	  }
	 



	
	
	
}
