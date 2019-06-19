package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AsteroidHitAsteroidCommand extends Command {
private GameWorld gw;
	
	public AsteroidHitAsteroidCommand(GameWorld gw)
	{
		super("Asteroids Destroyed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.removeAsteroids();
	}
}
