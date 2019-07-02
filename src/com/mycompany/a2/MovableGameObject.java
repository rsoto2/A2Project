package com.mycompany.a2;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public abstract class MovableGameObject extends GameObject implements Movable {
	
	private int speed;
	private int direction;
	
	
	public MovableGameObject(int color, int speed, int dir, double x, double y) {
		super(color, x, y);
		//this.setSpeed(speed);
		this.speed = speed;
		this.direction = dir;
		//this.setDirection(direction);
		
	}
	
	
	
	public MovableGameObject(int color)
	{
		super(color);
		//this.speed = speed;
		//this.direction = direction;
		this.speed = new Random().nextInt(10);
		this.direction = new Random().nextInt(360);
	}
//	public MovableGameObject() {
//		speed = rand.nextInt(16);
//		direction = rand.nextInt(360);
//	}
	
	public void setSpeed(int s) {
		this.speed = s;
	}
	
	public int getSpeed() {
		//return this.speed;
		return this.speed;
	}
	
	public void setDirection(int d) {
		this.direction = d;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	@Override
	public void move() {
		double ang = Math.PI / 180 * ((90 - this.getDirection()));
		double directionX = Math.cos(ang) * getSpeed();
		double directionY = Math.sin(ang) * getSpeed();

		
		this.setLocation(this.getLocationX() + directionX, this.getLocationY() + directionY);
	
	
	}
	
	

}
