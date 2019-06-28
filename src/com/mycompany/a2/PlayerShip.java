package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class PlayerShip extends Ship implements ISteerable {
	
	
	private MissileLauncher launcher;

	private int lives;
	private int playerScore;
	private PlayerShip ps;
	
	
	
	public PlayerShip() 
	{
		
		//super(ColorUtil.BLUE, 0, 0, x, y);
		super(ColorUtil.BLUE, 0, 0, 512, 384);
		//this.move();
		//move();
		//super(ColorUtil.YELLOW, 0, 0);
		//this.setLocation(0, 0);
		//this.getDirection();
		//this.setSpeed(0);
		//setColor(0,150, 40);
		//setLocation(512, 384);;
		lives = 3;
		playerScore = 0;
		launcher = new MissileLauncher(this.getLocationX(), this.getLocationY(), this.getSpeed(), this.getDirection(), ps);
		 //System.out.println(this.toString());
		
	}
	
	MissileLauncher getMissileLauncher() 
	{
		return launcher;
		
	}

	public void changeLauncherDirection(int amount)
	{
		launcher.Steer(amount);
	}
	
	public int getLauncherDirection()
	{
		return launcher.getDirection();
	}
	
//	public int incrementSpeed(int speed) {
//		return this.getSpeed() - 1;
//	}
//	
//	
//	
//	public int decreaseSpeed(int speed) {
//		return this.getSpeed() - 1;
//	}
	
	
	public void setLives(int l) {
		lives = l;
		}
	
	public int getLives() {
		return lives;
	}
	
	
	
//	public int getLauncherDirection()
//	{
//		return launcher.getDirection();
//	}
	
	public void setPlayerScore(int s) {
		playerScore = s;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public void reset() 
	{
		this.setLocation(512, 384);
	}
	
	public void incSpeed()
	{
		int current = getSpeed();
		setSpeed(current + 1);
		
	}
	
	public void deSpeed()
	{
		int current = getSpeed() - 1;
		setSpeed(current - 1);
	}
	
	public String toString() {
		return //("PlayerShip: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
		("PlayerShip Loc = : " + getLocation() + 
		" color= " + GameObject.getColorString(getColor()) + 
		" speed= " + Math.round(getSpeed()) + 
		" dir= " + getDirection() +
		" direction of ml = " + launcher.getDirection()
		);
	}

	@Override
	public void Steer(int amount) {
		// TODO Auto-generated method stub
		if(getDirection() == 0 && amount < 0) 
		{
			setDirection(359);
		}
		else 
		{
			setDirection(getDirection() + amount);
		}
		
		
	}

	
//	public void draw(Graphics g, Point origin)
//	{
//		int x = (int)this.getX() + (int)origin.getX();
//		int y = (int) this.getY() + (int) origin.getY();
//		g.setColor(color);
//	}

	
	
}
