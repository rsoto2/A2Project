package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {

	
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw)
	{
		
		this.gw = gw;
		
	}
	
	
	
	
	
	
	@Override
	public int getPlayerScore() {
		// TODO Auto-generated method stub
		return gw.getPlayerScore();
	}






	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return gw.getMissileCount();
	}






	@Override
	public int getElapseTime() {
		// TODO Auto-generated method stub
		return gw.getElapseTime();
	}



}
