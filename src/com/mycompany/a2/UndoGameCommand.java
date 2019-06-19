package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class UndoGameCommand extends Command {

	
	private GameWorld gw;
	
	public UndoGameCommand(GameWorld gw)
	{
		super("Undo Game");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Undoing Game");
	}
	
	
}
