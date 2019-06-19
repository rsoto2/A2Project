package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;

public class MapView extends Container implements Observer {
	
	private int height;
	private int width;
	
	
	
	public MapView()
	{
		this.height = this.getHeight();
		this.width = this.getWidth();
		
		
		
		
	}
	public int getWidth() 
	{
		return width;
	}
	
	public void setWidth(int w)
	{
		this.width = w;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int h)
	{
		this.height = h;
	}
	
	
	
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		GameWorld gw = (GameWorld) observable;
		System.out.println("Update");
		gw.printMap();
		
	}

}
