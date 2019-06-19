package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSHitsNPSCommand extends Command {
private GameWorld gw;
	
	public PSHitsNPSCommand(GameWorld gw)
	{
		super("PS and NPS Destroyed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.removeNPSAndPS();
	}
}
