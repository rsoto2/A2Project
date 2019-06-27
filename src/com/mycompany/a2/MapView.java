package com.mycompany.a2;

import java.util.Observable;
import com.codename1.ui.Graphics;

import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class MapView extends Container implements Observer {
	
	private int height;
	private int width;
	//private GameWorld gw;
	private IGameWorld gw;
	
	private TextArea mapView;
	private SpaceCollection objects;
	Container cont;
	
	
	public MapView(GameWorld gw)
	{
		
		this.height = this.getHeight();
		this.width = this.getWidth();
		
		cont = new Container();
		
		
		this.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
		//mapView = new TextArea();
		add(cont);
		//add(BorderLayout.CENTER,cont);

		//this.add(mapView);
		//mapView.setFocusable(false);
		//mapView.setEnabled(false);
		
		
	}
	
	

	public int getMapWidth() 
	{
		return width;
	}
	
	public void setMapWidth(int w)
	{
		this.width = w;
	}
	
	public int getMapHeight()
	{
		return height;
	}
	
	public void setMapHeight(int h)
	{
		this.height = h;
	}
	
	
	
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
//		IGameWorld gw = (IGameWorld) observable;
//		
//		//System.out.println("Update");
//		gw.printMap();
		
		IGameWorld gw = (IGameWorld) data;
		this.gw = gw;
		

		
			
		
		
		this.repaint();
	}
	
		public void paint(Graphics g)
	{
		super.paint(g);
		IIterator it = this.gw.getObjectIterator();
		while(it.hasNext()) {
			((GameObject) it.getNext()).paint(g);
		}
		
	}
	

	

	
	
}
