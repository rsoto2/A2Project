package com.mycompany.a2;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {

	
	private GameWorld gw;
	public SoundCommand(GameWorld gw)
	{
		super("Sound OFF");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((CheckBox) e.getComponent()).isSelected()) {
			
			gw.setSound(false);
			
			
		}else {
			gw.setSound(true);
		}
	}
	
	
			
	
	
	
}
