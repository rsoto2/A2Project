package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class AddShipCommand extends Command {
	private GameWorld gw;
	
	public AddShipCommand(GameWorld gw) 
	{
		super("Add Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.newPS();
	}

}
