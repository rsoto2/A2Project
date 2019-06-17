package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer{

	private Label pointsValueLabel;
	private Label missileCntValue;
	private Label elapsedTimeValue;
	private int livesValueLabel;
	
	
	
	public PointsView()
	{
		Label pointsTextLabel = new Label("Points: ");
		Label missileTextValue = new Label("Missiles: ");
		Label elapsedTextValue = new Label("Time: ");
		
		pointsValueLabel = new Label("0");
		missileCntValue = new Label("0");
		elapsedTimeValue = new Label("0");
		//livesValueLabel = new Label("0");
		
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		pointsValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		missileTextValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		missileCntValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		elapsedTextValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		elapsedTimeValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
	
		
		
		
		Container myContainer = new Container();
		
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		myContainer.add(pointsTextLabel);
		myContainer.add(pointsValueLabel);
		
		myContainer.add(missileTextValue);
		myContainer.add(missileCntValue);
		
		
		myContainer.add(elapsedTextValue);
		myContainer.add(elapsedTimeValue);
		
		
		this.add(myContainer);
		//this.add(pointsTextLabel);
		//this.add(missileCntValue);
		//this.add(elapsedTimeValue);
	}



	@Override
	public void update(Observable observable, Object data) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		IGameWorld gw = (IGameWorld) data;
		this.pointsValueLabel.setText(" " + gw.getPlayerScore());
		this.missileCntValue.setText(" "  + gw.getMissileCount());
		this.elapsedTimeValue.setText(" " + gw.getElapseTime());
		this.repaint();
		
		
	}
	
}
