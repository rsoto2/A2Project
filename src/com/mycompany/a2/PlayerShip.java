package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class PlayerShip extends Ship implements ISteerable {
	
	
	
	static private MissileLauncher launcher;
	private int lives;
	private int playerScore;
	private PlayerShip ps;
	private int fuelLevel =  15;
	
	
	public PlayerShip() 
	{
		
		//super(ColorUtil.BLUE, 0, 0, x, y);
		super(ColorUtil.BLUE, 0, 0, 512, 384);
		//this.move();
		//move();
		//super(ColorUtil.YELLOW, 0, 0);
		//this.setLocation(0, 0);
		//this.getDirection();
		this.setSpeed(0);
		//setColor(0,150, 40);
		//setLocation(512, 384);;
	
		lives = 3;
		playerScore = 0;
		PlayerShip.launcher = new MissileLauncher(this.getLocationX(), this.getLocationY(), this.getSpeed(), 0, ps);
		 //System.out.println(this.toString());
		
	}
	
	MissileLauncher getMissileLauncher() 
	{
		return this.launcher;
		
	}

 void setLives(int l) {
		lives = l;
		}
	
	public int getLives() {
		return lives;
	}
	
	
	

	public void setPlayerScore(int s) {
		playerScore = s;
	}
	
	public int getPlayerScore() {
		return playerScore;
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

	public void decrementFuelLevel() {
		// TODO Auto-generated method stub
		this.fuelLevel--;
	}

	
}
