package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SaveGameCommand extends Command{

	private GameWorld gw;
	
	public SaveGameCommand(GameWorld gw)
	{
		super("Save Game");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Saving game");
	}

}


