package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class TurnRightCommand extends Command{
private GameWorld gw;
	
	public TurnRightCommand(GameWorld gw) 
	{
		super("Turn Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.turnShipRight();
	}

}
