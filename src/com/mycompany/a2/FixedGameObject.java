package com.mycompany.a2;

public abstract class FixedGameObject extends GameObject {

	private int uniqueID;
	private int id;	
	
	
public FixedGameObject(int location, int color) {
		super(color);
		// TODO Auto-generated constructor stub
		this.setLocation(30,80);
	}



}
