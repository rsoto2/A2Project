package com.mycompany.a2;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public abstract class MovableGameObject extends GameObject implements Movable {
	
	private int speed;
	private int direction;
	
	
	public MovableGameObject(int color, int speed, int dir) {
		super(0, color);
		//this.setSpeed(speed);
		this.speed = speed;
		this.direction = dir;
		//this.setDirection(direction);
		
	}
//	public MovableGameObject() {
//		speed = rand.nextInt(16);
//		direction = rand.nextInt(360);
//	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	
	public int getSpeed() {
		//return this.speed;
		return speed;
	}
	
	public void setDirection(int d) {
		direction = d;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	@Override
	public void move() {
		double ang = Math.PI * ((90 - this.getDirection()/180));
		double directionX = Math.cos(ang) * getSpeed();
		double directionY = Math.sin(ang) * getSpeed();
//		double directionX = Math.cos(ang) * getSpeed();
//		double directionY = Math.sin(ang) * getSpeed();
		//this.setLocationX((double) (this.getLocationX() + directionX));
		//this.setLocationY((double) (this.getLocationY() + directionY));
		this.setLocation(this.getLocationX() + directionX, this.getLocationY() + directionY);
	}
	
	

}
