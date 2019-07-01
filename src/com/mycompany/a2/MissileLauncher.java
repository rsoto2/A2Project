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
		//this.getDirection();
		//this.setDirection(direction);
		//this.setSpeed(speed);
		
		//this.setDirection(0);
		
		this.amount = 15;
		
	}
	
	
	public String toString() {
		return "Player MissileLauncher: " + getDirection();
	}
	
//	public int getMissileLauncherDirection() {
//		return getDirection();
//	}
//	
//	public void setMissileLauncherDirection(int amount) {
//		setDirection(amount);
//	}

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
	
 
	
	
//	@Override
//	public void Steer(int amount) {
//		// TODO Auto-generated method stub
//		this.setDirection((this.getDirection()) + amount /360);
//		
//		
//	}
	
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
