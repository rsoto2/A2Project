package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class NonPlayerShip extends Ship implements Movable{

	private int size;
	private NonSteerableMissile ml;
	private int x;
	private int y;
	private int fuelLevel = 15;
	public NonPlayerShip() {
		super(ColorUtil.MAGENTA);
		final int MIN_SIZE = 15;
		final int MAX_SIZE = 25;
		//this.setColor(300, 0, 0);
		this.size = GameObject.rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
	
		ml = new NonSteerableMissile(this, ColorUtil.MAGENTA, this.getSpeed(), this.getDirection(), this.getLocationX(), this.getLocationY());
		
		
	}
	
	public NonSteerableMissile getMl() {
		return this.ml;
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

	public void decrementFuelLevel() {
		// TODO Auto-generated method stub
		fuelLevel--;
		
	}
	
}
