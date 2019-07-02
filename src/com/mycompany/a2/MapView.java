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
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private int height;
	private int width;
	//private GameWorld gw;
	private IGameWorld gw;
	
	private TextArea mapView;
	private SpaceCollection getCollection;
	//Container cont;
	
	
	public MapView(GameWorld gw)
	{
		
		this.height = this.getHeight();
		this.width = this.getWidth();
		this.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		
//		this.setLayout(new BorderLayout());
//		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GREEN));
//		this.getAllStyles().setBgColor(ColorUtil.BLACK);
//		this.getAllStyles().setBgTransparency(225);
//		this.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
		//mapView = new TextArea();
		

		//this.add(mapView);
		//mapView.setFocusable(false);
		//mapView.setEnabled(false);
		
		
	}
	
	

	public int getMapWidth() 
	{
		return this.getWidth();
	}
	
	public void setMapWidth(int w)
	{
		this.width = w;
	}
	
	public int getMapHeight()
	{
		return this.getHeight();
	}
	
	public void setMapHeight(int h)
	{
		this.height = h;
	}
	

	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		//IGameWorld gw = (IGameWorld) observable;
		
		//System.out.println("Update");
		//gw.printMap();
		
		IGameWorld gw = (IGameWorld) data;
		this.gw = gw;
		//gw.printMap();
		
		
			
		
		
		this.repaint();
	}
	
		public void paint(Graphics g)
	{
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(), getY());

		if(gw != null)  {
		IIterator it = this.gw.getObjectIterator();
		while(it.hasNext()) {
			
		
			
			((GameObject) it.getNext()).draw(g, pCmpRelPrnt);
			
			
			
		}
		}
		
	}
	

	

	
	
}
