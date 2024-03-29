package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class QuitGameCommand extends Command {
	private GameWorld gw;
	
	public QuitGameCommand(GameWorld gw)
	{
		super("Quit Game");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getKeyEvent() != -1) {
		gw.quit();
		}
	}
	
}

