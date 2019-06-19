package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PSMissileHitsAsteroidCommand extends Command {
private GameWorld gw;
	
	public PSMissileHitsAsteroidCommand(GameWorld gw)
	{
		super("Asteroid Destroyed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.playerShipMissileKillAsteroid();
	}
}
