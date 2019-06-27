package com.mycompany.a2;

public class ObjectLocation {

	
	private float x;
	private float y;
	
	//creates object with set parameters
	public ObjectLocation(float xIn, float yIn){
		x = xIn;
		y = yIn;
	}
	
	private void setX(float newX) {
		x = newX;
	}
	
	private void setY(float newY) {
		y = newY;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setLocation(float newX, float newY) {
		setX(newX);
		setY(newY);
	}
	
	
}
