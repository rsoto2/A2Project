package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class SpaceStation extends FixedGameObject {
	
	private int blinkRate = 6;
	private boolean blinkLightOn = false;
	
	public SpaceStation() {
		super(0, ColorUtil.GREEN);
	}
		
	
	public void setBlinkRate(int b)
	{
		blinkRate = b;
	}
	
	public int getBlinkRate()
	{
		return blinkRate;
	}
	
	
	public void setLight(boolean f)
	{
		blinkLightOn = f;
	}
	
	public boolean getLight()
	{
		return blinkLightOn;
	}
	
	
	
	
	
	
	public String toString() {
		return ("Station: loc= " + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) +
		" color= " + GameObject.getColorString(getColor()) + 
		" blinkRate= " + blinkRate);
	}


	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		int xLoc = (int) ((int) this.getLocationX() + pCmpRelPrnt.getX());// shape location relative
		int yLoc = (int) ((int) this.getLocationY() + pCmpRelPrnt.getY());// to parents origin
		
		g.fillRect(xLoc, yLoc, 10, 10);
	}



}
