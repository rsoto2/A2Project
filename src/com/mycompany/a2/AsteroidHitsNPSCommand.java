package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AsteroidHitsNPSCommand extends Command {
private GameWorld gw;
	
	public AsteroidHitsNPSCommand(GameWorld gw)
	{
		super("Asteroid Detsroyed NPS");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.removeAstAndNPS();
	}

}
