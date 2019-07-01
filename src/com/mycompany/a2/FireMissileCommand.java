package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class FireMissileCommand extends Command {
private GameWorld gw;
private PlaySound fire;
	
	public FireMissileCommand(GameWorld gw) 
	{
		super("Fire Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getKeyEvent() != -1) {

		gw.fireMissile();
		fire = new PlaySound("firemissile.mp3");
		fire.play();
		}
	}

}


//setFocusable();