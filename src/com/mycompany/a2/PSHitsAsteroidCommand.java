package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSHitsAsteroidCommand extends Command {
private GameWorld gw;
	
	public PSHitsAsteroidCommand(GameWorld gw)
	{
		super("PS and Asteroid Destroyed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.removeAstAndPS();
	}
}
