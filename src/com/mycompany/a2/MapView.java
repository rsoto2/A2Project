package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.FlowLayout;

public class MapView extends Container implements Observer {
	
	private int height;
	private int width;
	//private GameWorld gw;
	//private IGameWorld gw;
	
	private TextArea mapView;
	private SpaceCollection objects;
	
	
	public MapView(GameWorld gw)
	{
		this.height = this.getMapHeight();
		this.width = this.getMapWidth();
		
	
		
		this.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
		mapView = new TextArea();
		this.add(mapView);
		this.setFocusable(false);
		this.setEnabled(false);
		
		
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
	
		IIterator it = gw.getObjectIterator();
		
		while(it.hasNext()) {
			
			//it.getNext().draw();
			
		}
		
		this.repaint();
	}




	
//	
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		Point pCmpRelPrnt = new Point(getX(), getY());
//		IIterator it = GameWorld.getCollection.getIterator();
//	}

	

//	public void paint(Graphics g) {
//		super.paint(g);
//		objects = gww.getCollection();
//		IIterator objectPainter = objects.getIterator();
//		
//		Object currentObj = new Object();
//		
//		while(objectPainter.hasNext() ){
//			ObjectLocation pCmpRelPrnt = new ObjectLocation(this.getX(), this.getY());
//			currentObj = objectPainter.getNext();
//			if(currentObj instanceof Movable) {		
//				int x = (int) ((GameObject)currentObj).getLocation().getX();
//				int y = (int) ((GameObject)currentObj).getLocation().getY();
//				int rightWall = this.getWidth() + this.getX();
//				int leftWall = this.getX();
//				int bottomWall = this.getY() + this.getHeight();
//				int topWall = this.getY();
//			
//			}
//			if(currentObj instanceof IDrawable) {
//				((IDrawable)currentObj).draw(g, pCmpRelPrnt);
//			}
//		}
//	}
	
	
}
