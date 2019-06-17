package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class IncreaseSpeedCommand extends Command{
private GameWorld gw;
	
	public IncreaseSpeedCommand(GameWorld gw) 
	{
		super("Increase Speed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.speedUpShip();
	}

}
