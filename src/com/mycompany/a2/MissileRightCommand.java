package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MissileRightCommand extends Command {
private GameWorld gw;
	
	public MissileRightCommand(GameWorld gw)
	{
		super("Missile Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.turnPSMLRight();
	}
}
