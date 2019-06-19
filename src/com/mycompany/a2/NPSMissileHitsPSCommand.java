package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NPSMissileHitsPSCommand extends Command {
private GameWorld gw;
	
	public NPSMissileHitsPSCommand(GameWorld gw)
	{
		super("PS Destroyed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.removeMissileAndPS();
	}
}
