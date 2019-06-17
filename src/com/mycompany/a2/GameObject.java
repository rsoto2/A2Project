package com.mycompany.a2;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {

	static Random rand = new Random();
	//private double xLocation;
	//private double yLocation;
	private Point2D location;
	private int color;
	//private final double MAX_X_Y = 0;
	private final double MAX_X = 1024;
	private final double MAX_Y = 768;
	
	
	public GameObject(double location, int color)
	{
		this.color = color;
		this.location = new Point2D(rand.nextInt((int) MAX_X + 1), rand.nextInt((int) MAX_Y));
		//this.xLocation = xLocation;
		//this.yLocation = yLocation;
	}
	
//	public GameObject() {
//		double x = Math.round((MAX_X * rand.nextDouble() * 10)) / 10;
//		double y = Math.round((MAX_Y * rand.nextDouble() * 10)) / 10;
//		location = new Point2D(x, y);
//	}
	
	public void setLocation(double x, double y)
	{
		location = new Point2D(x,y);
	}
	public int getColor() {
		return this.color;
	}
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}

	
	public double getLocationY() {
		return this.location.getY();
	}
	
	public double getLocationX() {
		return this.location.getX();
	}
	
	public Point2D getLocation() {
		return this.location;
	}
	
	
	public static String getColorString(int color) {
		
		return //"loc = " + location.getX() + ", " + location.getY() +
				ColorUtil.red(color) + ", " + ColorUtil.green(color) + ", " + ColorUtil.blue(color); 
		
	}

	
	
}
