package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship implements ISteerable {
	
	
	private MissileLauncher launcher;

	private int lives;
	private int playerScore;
	
	
	
	
	public PlayerShip() 
	{
		
		super(ColorUtil.BLUE, 0, 0);
	
		//this.move();
		//move();
		//super(ColorUtil.YELLOW, 0, 0);
		//this.setLocation(0, 0);
		//this.getDirection();
		//this.setSpeed(0);
		setColor(255,0,0);
		//setLocation(512, 384);;
		lives = 3;
		playerScore = 0;
		launcher = new MissileLauncher(this.getLocationX(), this.getLocationY(), this.getSpeed(), this.getDirection());
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
		setLocation(512, 384);
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


	
	
}
