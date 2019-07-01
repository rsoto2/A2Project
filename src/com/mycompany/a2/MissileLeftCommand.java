package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MissileLeftCommand extends Command {

private GameWorld gw;
private PlaySound robot;
	
	public MissileLeftCommand(GameWorld gw)
	{
		super("Launcher Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getKeyEvent() != -1) {
		gw.turnPSMLLeft();
		robot = new PlaySound("robot.mp3");
		robot.play();
		}
	}
	
	
}
