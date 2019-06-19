package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NPSMissileCommand extends Command {
private GameWorld gw;
	
	public NPSMissileCommand(GameWorld gw)
	{
		super("NPS Fire Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.launchMissile();
	}
}
