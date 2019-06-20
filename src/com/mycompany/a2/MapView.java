package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;

public class MapView extends Container implements Observer {
	
	private int height;
	private int width;
	private GameWorld gw;
	
	private TextArea mapValueTextArea;
	
	
	public MapView(GameWorld myGW)
	{
		this.height = this.getHeight();
		this.width = this.getWidth();
		
		this.height = this.getHeight();
		this.width = this.getWidth();
		this.gw = myGW;
		this.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		mapValueTextArea = new TextArea();
		this.add(mapValueTextArea);
		mapValueTextArea.setEditable(false);
		mapValueTextArea.setFocusable(false);
		
		
		
		
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
		//System.out.println("Update");
		gw.printMap();
		
	}

}
