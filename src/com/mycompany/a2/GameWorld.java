package com.mycompany.a2;

import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;



public class GameWorld extends Observable  {
	
	
	Random rand = new Random();
	public Vector<GameObject> store = new Vector<GameObject>();
	private final static double xWidth = 1024;
	private final static double yHeight = 768;
	private boolean hasPlayerShip = false;
	private int elapsedGameTime = 0;
	private int playerScore = 0;
	private int numPSMissiles = 0;
	private int playerLives = 3;
	private int clock;
	private int fuel;
	private PlayerShip ship;
	private PlayerShip s = null;
	private MissileLauncher m = null;
	
	
	
	public void addNewAsteroid() {
		Asteroid asteroid = new Asteroid();
		store.add(asteroid);
		System.out.println("A new Asteroid will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
 	
	
	public void newSpaceStation() {
		SpaceStation b = new SpaceStation();
		store.add(b);
		System.out.println("A new space station will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}
	
	public void newPS() {
		if(s == null) {
		s = new PlayerShip();
		store.add(s);
		System.out.println("A new PS will be created");
		}
		else {
			System.out.println("Playership already exists");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}
	
	public void newNPS() {
		NonPlayerShip y = new NonPlayerShip();
		store.add(y);
		System.out.println("A new NPS will be created");
	}
	
	public void init() {
	playerScore = 0;
	playerLives = 3;
	clock =0;
		
	}	
	
	
	public void fireMissile () throws IllegalArgumentException {
		//Boolean playerShip = false;
		for(int i = 0 ; i < store.size() ; i++) {
			if(store.elementAt(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) store.elementAt(i);
				if(ps.getMissileCount() > 0) { 
					ps.setMissileCount(ps.getMissileCount() -1);//Dec missile count by 1
				Missile ms1 = new Missile(ps.getColor(), ps.getLocationX(), ps.getLocationY(), ps.getSpeed(), ps.getDirection(), ps);
				store.add(ms1);
				System.out.println("PlayerShip has fired a Missile!");
				return;
				}else {
					System.out.println("PlayerShip has no more Missiles!");
				}
			}

		}
	}
	
	
	public void launchMissile() throws IllegalArgumentException{
		for(int i = 0 ; i < store.size() ; i++) {
			if(store.elementAt(i) instanceof NonPlayerShip) {
				NonPlayerShip nps = (NonPlayerShip) store.elementAt(i);
				if(nps.getMissileCount() > 0)  {
					nps.setMissileCount(nps.getMissileCount() -1);
				Missile ms1 = new Missile(nps.getColor(), nps.getLocationX(), nps.getLocationY(),  nps.getSpeed(), nps.getDirection(), nps);
				store.add(ms1);
				System.out.println("NonPlayerShip has fired a Missile!");
				return;
			
			}else {
				System.out.println("NonPlayerShip has no more Missiles!");
			}
			}
		}
	}
	
	
	
	public void tick() throws IllegalArgumentException{
		clock++;
		if(store.size() > 0) {
			//for(int i = 0; i < (store.size() - 1); i++) {
				for(int i = store.size() - 1; i >= 0; i--) {
				if(store.get(i) instanceof Movable) {
					Movable curMovableObj = (Movable) store.get(i);
					curMovableObj.move(); 
					
				}
				if(store.get(i) instanceof Missile) 
				{
					Missile curMissile = (Missile) store.get(i);
					int fuel = curMissile.getFuel();
					if(fuel > 1) 
						curMissile.setFuel(fuel - 1);
//					else {
//						curMissile = null;
//						store.remove(i);
//					}
				}
				if(store.get(i) instanceof SpaceStation)
				{
					SpaceStation spc = (SpaceStation) store.get(i);
					if(clock % spc.getBlinkRate() == 0)
					{
						if(spc.getLight())
							spc.setLight(false);
						else 
							spc.setLight(true);
					}
				}
				
			}
		}
		System.out.println("Tick");
		
		//clock++;
	}
	
//	
//	public void jump () throws IllegalArgumentException
//	{	
//		
//		for(int i = 0; i < store.size(); i++)
//		{
//		if(store.get(i) instanceof PlayerShip) 
//			{
//		PlayerShip ps = (PlayerShip) store.elementAt(i);
//		ps.setLocation(512, 384);
//		System.out.println("Ship jumped through hyperspace");
//			}
//		}
//		
//	}
	
	
	public void jump () throws IllegalArgumentException
	{	
		
		for(int i = 0; i < store.size(); i++)
		{
		if(store.elementAt(i) instanceof PlayerShip) 
			{
		PlayerShip ps = (PlayerShip) store.elementAt(i);
		//ps.setLocation(512, 384);
		ps.reset();
		System.out.println("Ship jumped through hyperspace");
			}
		 	}
		
	}
	
	
	public void turnPSML() throws IllegalArgumentException {
		for(int i = 0; i < store.size(); i++) 
		{
		
			PlayerShip ps = (PlayerShip) store.elementAt(i);
			//if(ps.getMissileLauncher().getDirection() == 0) {
				//ps.getMissileLauncher().setDirection(-90);
				ps.changeLauncherDirection(1);
				System.out.println("Turning direction of missile launcher");
				//}
				//else 
					//System.out.println("Can't turn missile");
		}
	}
	
	
	
//	public void turnShipLeft() {
//		if(s instanceof PlayerShip) {
//			s.setDirection(-90);
//			System.out.println("Turning left");
//		}
//		else {
//			System.out.println("Can't go left.");
//		}
//	}
	
	public PlayerShip findPlayer()
	{
		int i = -1;
		PlayerShip temp = null;
		return temp;
	}
	
	public void turnShipLeft() {
		for(int i = 0; i < store.size(); i++) 
		{
			if(store.get(i) instanceof PlayerShip) {
			PlayerShip ps = (PlayerShip) store.elementAt(i);
			//(ps.getDirection() == 0)
				//ps.setDirection(ps.getDirection() - 1);
			ps.Steer(1);
		System.out.println("Turning direction of ship");
			}
			}
	}
	
	public void speedUpShip() 
	{
		for(int i = 0; i < store.size(); i++)
			
		{
			if(store.get(i) instanceof PlayerShip) {
			PlayerShip ps = (PlayerShip) store.elementAt(i);
			//if(ps.getSpeed() == 0)
				ps.setSpeed(ps.getSpeed() + 1);
				//ps.move();
			System.out.println("Increasing speed");
			}
		}
	}
	
	public void slowUpShip() 
	{
		for(int i = 0; i < store.size(); i++)
		{
			if(store.get(i) instanceof PlayerShip) {
			PlayerShip ps = (PlayerShip) store.elementAt(i);
			//if(ps.getSpeed() == 0)
				ps.setSpeed(ps.getSpeed() - 1);
				//ps.move();
			System.out.println("Decreasing speed");
			}
		}
	}
	
//	public void turnShipRight() {
//		if(s instanceof PlayerShip) {
//			s.setDirection(1);
//			System.out.println("Turning Right");
//		}
//		else {
//			System.out.println("Can't go right");
//		}
//	}
	
	public void turnShipRight() 
	{
		for(int i = 0; i < store.size(); i++) 
		{
			if(store.get(i) instanceof PlayerShip) {
			PlayerShip ps = (PlayerShip) store.elementAt(i);
			//if(ps.getDirection() == 0)
				//ps.setDirection(ps.getDirection() + 1);
			ps.Steer(-1);
			System.out.println("Turn direction of ship");
			}
			
		}
	}
	
	public void reSupply() {
		if(s instanceof PlayerShip) {
 			s.setMissileCount(10);
			System.out.println("Missiles Reloaded");
			
		}
		else {
			System.out.println("Can't resupply");
		}
	}
	
	
	
	public void playerShipMissileKillAsteroid() //player ship destroys asteroid 
    {
        boolean asteroidExists = false;
        boolean missileExists = false;
        Missile ms = null;
        Asteroid ast = null;
        
        for (int i = 0; i <store.size() && (!asteroidExists || !missileExists); i++)
        {
            if ((store.elementAt(i) instanceof Asteroid) && !asteroidExists)
            {
                ast = (Asteroid) store.elementAt(i);
                asteroidExists = true;
            }        
            
            if ((store.elementAt(i) instanceof Missile) && !missileExists)
            {
                ms = (Missile) store.elementAt(i);
                missileExists = true;
            }        
        }
        
        if(missileExists && asteroidExists)
        {
            store.remove(ast);
            store.remove(ms);
            //ps.setPlayerScore(ps.PlayerScore() + 1);
            playerScore += 1;
            
            System.out.println("Player has destroyed an Asteroid with a missile! Score increased by 1!");
        }
        else
            System.out.println("Error: A missile or Asteroid doesn't exist.");        
    }
	
	
	
	
	public void removeMissileAndPS() //NPS missile destroys player ship
    {
        boolean psExists = false;
        boolean missileExists = false;
        Missile ms = null;
        PlayerShip ps = null;
        
        for (int i = 0; i < store.size() && (!psExists || !missileExists); i++)
        {
            if ((store.elementAt(i) instanceof PlayerShip) && !psExists)
            {
                ps = (PlayerShip) store.elementAt(i);
                psExists = true;
            }        
            
            if ((store.elementAt(i) instanceof Missile) && !missileExists)
            {
                ms = (Missile) store.elementAt(i);
                missileExists = true;
            }        
        }
        
        if(missileExists && psExists)
        {
            store.remove(ps);
            store.remove(ms);
            //this.setPlayerLives(this.getPlayerLives() - 1);
          // ps.setLives(ps.getLives() - 1);
            playerLives -= 1;
            System.out.println("Player has lost a life! Player Lives Remaining: " +  playerLives);
        }
        else
            System.out.println("Error: A missile or Player Ship doesn't exist.");    
    }
	
	public void removeMissileAndNPS() throws IllegalArgumentException //PS missile destorys NPS
    {
        boolean npsExists = false;
        boolean missileExists = false;
        Missile ms = null;
        NonPlayerShip nps = null;
        
        for (int i = 0; i < store.size() && (!npsExists || !missileExists); i++)
        {
            if ((store.elementAt(i) instanceof NonPlayerShip) && !npsExists)
            {
                nps = (NonPlayerShip) store.elementAt(i);
                npsExists = true;
            }        
            
            if ((store.elementAt(i) instanceof Missile) && !missileExists)
            {
                ms = (Missile) store.elementAt(i);
                missileExists = true;
            }        
        }
        
        if(missileExists && npsExists)
        {
            store.remove(nps);
            store.remove(ms);
            //this.setPlayerLives(this.getPlayerLives() + 1);
            playerLives += 1;
            playerScore += 1;
            System.out.println("Player destroyed Non Player Ship. Update Score: " + playerLives);
        }
        else
            System.out.println("Error: A missile or NonPlayer Ship doesn't exist.");    
    }
	
	
	public void removeAstAndPS() // asteroid crashes into player ship
    {
        boolean psExists = false;
        boolean astExists = false;
        Asteroid ast = null;
        PlayerShip ps = null;
        
        for (int i = 0; i < store.size() && (!psExists || !astExists); i++)
        {
            if ((store.elementAt(i) instanceof PlayerShip) && !psExists)
            {
                ps = (PlayerShip) store.elementAt(i);
                psExists = true;
            }        
            
            if ((store.elementAt(i) instanceof Asteroid) && !astExists)
            {
                ast = (Asteroid) store.elementAt(i);
                astExists = true;
            }        
        }
        
        if(astExists && psExists)
        {
            store.remove(ps);
            store.remove(ast);
            //this.setPlayerLives(this.getPlayerLives() - 1);
            playerLives -= 1;
            System.out.println("Player has lost a life! Player Lives Remaining: " + playerLives);
        }
        else
            System.out.println("Error: An asteroid or Player Ship doesn't exist.");    
    }
	

	
	public void removeNPSAndPS() //player ship and non player ship crash
    {
        boolean psExists = false;
        boolean npsExists = false;
        NonPlayerShip nps = null;
        PlayerShip ps = null;
        
        for (int i = 0; i < store.size() && (!psExists || !npsExists); i++)
        {
            if ((store.elementAt(i) instanceof PlayerShip) && !psExists)
            {
                ps = (PlayerShip) store.elementAt(i);
                psExists = true;
            }        
            
            if ((store.elementAt(i) instanceof NonPlayerShip) && !npsExists)
            {
                nps = (NonPlayerShip) store.elementAt(i);
                npsExists = true;
            }        
        }
        
        if(npsExists && psExists)
        {
            store.remove(ps);
            store.remove(nps);
            //this.setPlayerLives(this.getPlayerLives() - 1);
            playerLives -= 1;
            System.out.println("PS collided with a NPS! Player has lost a life! Player Lives Remaining: " + playerLives);
        }
        else
            System.out.println("Error: A Non Player Ship or Player Ship doesn't exist.");    
    }
	
	
	
	public void removeAstAndNPS() //asteroid hits non player ship
    {
        boolean npsExists = false;
        boolean astExists = false;
        Asteroid ast = null;
        NonPlayerShip nps = null;
        
        for (int i = 0; i < store.size() && (!npsExists || !astExists); i++)
        {
            if ((store.elementAt(i) instanceof NonPlayerShip) && !npsExists)
            {
                nps = (NonPlayerShip) store.elementAt(i);
                npsExists = true;
            }        
            
            if ((store.elementAt(i) instanceof Asteroid) && !astExists)
            {
                ast = (Asteroid) store.elementAt(i);
                astExists = true;
            }        
        }
        
        if(astExists && npsExists)
        {
            store.remove(nps);
            store.remove(ast);
            System.out.println("An asteroid and a Non Player Ship Collided! Both are Destroyed!");    
        }
        else
            System.out.println("Error: An asteroid or Non Player Ship doesn't exist.");    
    }
	
	
	

	//asteroids crash into each other
	public void removeAsteroids() 
	{
	 boolean astro1 = false;
	 boolean astro2 = false;
	 int ast1 = 0;
	 int ast2 = 0;
		
		for(int i = 0; i < store.size(); i++ ) {
			if(store.get(i) instanceof Asteroid && astro1 != false) 
			{
				ast1 = i;
				astro1 = true;
			}
			if (store.get(i) instanceof Asteroid && astro2 != false)
			{
				ast2 = i;
				astro2 = true;
			}
			
		}
		
		if(astro2 != true && astro1 != true) 
		{
			
			
				store.remove(ast2);
				store.remove(ast1);
				System.out.println("Both asteroids destroyed");
				
		}
		else 
			System.out.println("Error or Asteroid don't exist");
	}
	
	public void printMap() {
		//String map = null;
		for(GameObject i : store) {
			//map = (i.toString() + "\n");
			if(i instanceof Missile) {
				if( ((Missile) i).getOwner()      instanceof PlayerShip) {
					System.out.println(((Missile)i).missileString(true));
				}else {
					System.out.println(((Missile)i).missileString(false));
				}
			}else {
				System.out.println(i.toString());
			}
		}
		
	}
	
	
	
	public void printDisplay() throws IllegalArgumentException {
		for(int i = 0; i < store.size(); i++)
		{
			if(store.elementAt(i) instanceof PlayerShip) {
				System.out.println("PlayerShip: playerScore = " + this.playerScore +" Number of Missiles= " + (((Ship) store.get(i)).getMissileCount())
						+ " Number of lives = " + (((PlayerShip) store.get(i)).getLives())
						);
						
			}
		}
		
	}


	public int getPlayerScore() {
		// TODO Auto-generated method stub
		return playerScore;
	}


	public int getMissileCount() {
		// TODO Auto-generated method stub
		return numPSMissiles;
	}


	public int getElapseTime() {
		// TODO Auto-generated method stub
		return elapsedGameTime;
	}
	
	
	public void quit()
	{
		System.exit(0);
	}
	
	
	

}
