package com.mycompany.a2;

public class NonSteerableMissile extends MovableGameObject implements Movable {
private NonPlayerShip owner;
	
	public NonSteerableMissile(NonPlayerShip owner , int objectColor, int speed, int direction, double x, double y) {
		super(objectColor, speed, direction);
		this.getLocation();
		this.setColor(255, 0, 0);
		this.setSpeed(15);
		this.getDirection();
		this.owner = owner;
	}

	@Override
	public void move() {
		this.setLocation(owner.getLocationX(), owner.getLocationY());	
	}
}
