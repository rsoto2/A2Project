package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class NonPlayerShip extends Ship{

	private int size;
	private MissileLauncher missileLauncher;
	
	
	public NonPlayerShip() {
		super(ColorUtil.GRAY, 0, 0);
		this.setSpeed(rand.nextInt(16));
		this.setLocation(rand.nextDouble(), rand.nextDouble());
		this.setDirection(rand.nextInt(360));
		final int MIN_SIZE = 15;
		final int MAX_SIZE = 25;
		this.setColor(300, 0, 0);
		this.size = GameObject.rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
		setMissileCount(4);
		
		
		
	}
	
	

	
	public int getSize()
	{
	 return this.size;
	}
	
	public String toString() {
		return (
				"NonPLayerShip: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
				" color= " + GameObject.getColorString(getColor()) + 
				" speed= " + Math.round(getSpeed()) + 
				" dir= " + getDirection() + 
				" size= " + this.getSize()
				);
	}
	
}
