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
	private Label livesValueLabel;
	private Label soundLabel;
	private PlaySound end;
	
	
	
	public PointsView(GameWorld gw)
	{
		Label pointsTextLabel = new Label("Points: ");
		Label missileTextValue = new Label("Missiles: ");
		Label elapsedTextValue = new Label("Time: ");
		Label livesTextValue = new Label("Lives: ");
		Label soundTextValue = new Label("Sound: ");
		
		//labels
		pointsValueLabel = new Label(Integer.toString(gw.getPlayerScore()));
		missileCntValue = new Label(Integer.toString(gw.getMissileCount()));
		elapsedTimeValue = new Label(Integer.toString(gw.getElapseTime()));
		livesValueLabel = new Label(Integer.toString(gw.getPlayerLives()));
		soundLabel = new Label("OFF");
		
		//labels
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		missileTextValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		elapsedTextValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		livesTextValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundTextValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		
		
		//container
		Container myContainer = new Container();
		
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		myContainer.add(pointsTextLabel);
		myContainer.add(pointsValueLabel);
		
		myContainer.add(missileTextValue);
		myContainer.add(missileCntValue);
		
		
		myContainer.add(elapsedTextValue);
		myContainer.add(elapsedTimeValue);
		
		myContainer.add(livesTextValue);
		myContainer.add(livesValueLabel);
		
		myContainer.add(soundTextValue);
		myContainer.add(soundLabel);
		
		
		this.add(myContainer);
	}



	@Override
	public void update(Observable observable, Object data) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		IGameWorld gw = (IGameWorld) data;
		this.pointsValueLabel.setText(" " + gw.getPlayerScore());
		this.missileCntValue.setText(" "  + gw.getMissileCount());
		this.elapsedTimeValue.setText(" " + gw.getElapseTime());
		this.livesValueLabel.setText(" " + gw.getPlayerLives());
		
		if(gw.getSound() == true)
		{
			this.soundLabel.setText("ON");
		}
		else {
			this.soundLabel.setText("OFF");
		}
		if(gw.getPlayerLives() == 0)
		{
			end = new PlaySound("lose.mp3");
			end.play();
			
		}
		
		
		this.repaint();
		
		
	}
	
}
