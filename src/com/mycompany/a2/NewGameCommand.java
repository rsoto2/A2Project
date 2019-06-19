package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NewGameCommand extends Command{

	private GameWorld gw;
	
	public NewGameCommand(GameWorld gw)
	{
		super("New Game");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("New game will be created");
		
	}
	
}
