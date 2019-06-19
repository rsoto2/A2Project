package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSMissileHitsNPSCommand extends Command {

private GameWorld gw;
	
	public PSMissileHitsNPSCommand(GameWorld gw)
	{
		super("NPS Destroyed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.removeMissileAndNPS();
	}
}
