package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MissileRightCommand extends Command {
private GameWorld gw;
private PlaySound robot;
	
	public MissileRightCommand(GameWorld gw)
	{
		super("Missile Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getKeyEvent() != -1) {
		gw.turnPSMLRight();
		robot = new PlaySound("robot.mp3");
		robot.play();
		}
	}
}
