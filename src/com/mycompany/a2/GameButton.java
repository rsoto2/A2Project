package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;

public class GameButton extends Button {
	
	public GameButton(String button) 
	{
		super(button);
		this.getAllStyles().setBgColor(ColorUtil.BLUE);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setPadding(5, 5, 2, 2);
	}
	
}
