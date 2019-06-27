package com.mycompany.a2;
import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

import java.lang.Math;

public class Asteroid extends MovableGameObject implements Movable, IDrawable {
	private int size;
	
	private static final int MAX_SPEED = 15;
	private static final int MAX_DIR = 360;
	private static final int MIN = 0;
	final int MIN_SIZE = 6;
	final int MAX_SIZE = 30;
	public Asteroid() {
		super(ColorUtil.BLACK, MAX_SPEED, MAX_DIR);
		setColor(255, 0, 0);
		this.size = GameObject.rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
		this.setSpeed(rand.nextInt(20));
		this.setDirection(rand.nextInt(360));
		setLocation(rand.nextDouble() * 1024, rand.nextDouble() * 768);
		//System.out.println(this.toString()); //DEBUG LINE 
	}
	
	public int getSize() {
		
		return this.size;

	}
	
	
public String toString() 	
{
	return (
		"Asteroid: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
		" color= " + GameObject.getColorString(getColor()) + 
		" speed= " + Math.round(getSpeed()) + 
		" dir= " + getDirection() + 
		" size= " + this.getSize()
		);
	
}


	

public void draw(Graphics g) {
	// TODO Auto-generated method stub
	g.setColor(this.getColor());
	int xLoc = (int) this.getLocationX();// shape location relative
	int yLoc = (int) this.getLocationY();// to parents origin
	
	g.fillRect(xLoc, yLoc, 10, 10);
	
}


	
	
}
