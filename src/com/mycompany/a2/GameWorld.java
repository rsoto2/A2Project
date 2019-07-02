package com.mycompany.a2;

import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;




public class GameWorld extends Observable  implements IGameWorld{
	
	
	Random rand = new Random();
	public Vector<GameObject> store = new Vector<GameObject>();
	static private int gwidth = 1024;
	static private int gheight = 768;
	private boolean hasPlayerShip = false;
	private int elapsedGameTime = 0;
	private int playerScore = 0;
	private int numPSMissiles;
	private int playerLives = 3;
	private int clock;
	private int fuel;
	private PlayerShip ship;
	private PlayerShip s = null;
	private MissileLauncher m = null;
	private boolean soundOn = true;
	private SpaceCollection objects;
	//public GameObject o;
	private int numNPSMissiles;
	private PlaySound gs;
	//private GSound gs;
	private int a;
	private int non;
	private int p;
	private PlaySound fire;
	private boolean enable;
	
	public void addNewAsteroid() {
		objects.add(new Asteroid());
		a++;
		System.out.println("A new Asteroid will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
 	
	
	public void newSpaceStation() {
		objects.add(new SpaceStation());
		System.out.println("A new space station will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}
	
	public void newPS() {
		//if(s == null) {
		//s = new PlayerShip();
		if(p == 0) {
		//store.add(s);
		objects.add(new PlayerShip());
		this.p = 1;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		System.out.println("A new PS will be created");
	}
		else {
			System.out.println("Playership already exists");
		}
		
		
	}
	
	public void newNPS() {
		//NonPlayerShip y = new NonPlayerShip();
		
		objects.add(new NonPlayerShip());
		non++;
		System.out.println("A new NPS will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void init() {
	playerScore = 0;
	playerLives = 3;
	clock =0;
	soundOn = true;
	numPSMissiles = 10;
	objects = new SpaceCollection();
	numNPSMissiles = 4;
	a = 0;
	p = 0;
	non = 0;
	//gs = new PlaySound("music.mp3");
	
	
	
		
	}	
	
	
	public void fireMissile () throws IllegalArgumentException {
			

		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
		GameObject o = (GameObject) it.getNext();			
			
			if(o instanceof PlayerShip) {
				if(((PlayerShip) o).getMissileLauncher() != null) {
				if(getMissileCount() > 0) { 
					setMCount(getMissileCount() -1);
				
				
				objects.add(new Missile(((PlayerShip) o)));

			
				System.out.println(getMissileCount() + " missiles left");
				System.out.println("PlayerShip has fired a Missile!");
				((PlayerShip) o).decrementFuelLevel();
				
				
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				}		
				
				}
				else {
					System.out.println("PlayerShip has no more Missiles!");
				}
				
			}
			return;
			}
		//return;
				
		}
	
	
	
	public void launchMissile() throws IllegalArgumentException{

		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
		GameObject o = (GameObject) it.getNext();			
			
			if(o instanceof NonPlayerShip) {
				if(((NonPlayerShip) o).getMl() != null) {
				if(getNPSCount() > 0)  { 
					setNPSCount(getNPSCount() -1);
					
				
				//Missile ms1 = new Missile(((NonPlayerShip) o));
				
				objects.add(new Missile((NonPlayerShip)o));
				
				
				System.out.println(getNPSCount() + " missiles left");
				System.out.println("NonPlayerShip has fired a Missile!");
				
				
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				
				
				}
				
				}else {
					System.out.println("NonPlayerShip has no more Missiles!");
				}
				
			}
			return;
			}
	
	//	return;
		
	}
	
	
	
	public void tick() throws IllegalArgumentException{

		IIterator iter = objects.getIterator();
		
		while(iter.hasNext()) {
			
			int i = iter.current();
			GameObject obj = (GameObject) iter.getNext();
			
			if(!(obj instanceof FixedGameObject)) {
				//((MovableGameObject) obj).move();
				((MovableGameObject) obj).move();
			}
			
			else if(obj instanceof Missile && ((Missile) obj).getFuel() != 1) {
				((Missile) obj).setFuel(fuel - 1);;
			
			}

			
		}
		
		elapsedGameTime++;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	
	
	public void jump () throws IllegalArgumentException
	{	
		
		
		IIterator i = objects.getIterator();
		while(i.hasNext())
		{
			int index = i.current();
			GameObject o = (GameObject) i.getNext();
			if(o instanceof PlayerShip)
			{
				((PlayerShip) o).setLocation(512, 384);
				((PlayerShip) o).setSpeed(0);
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				System.out.println("Jumped through hyperspace");
				return;
				
			}
		}
		
		System.out.println("Error");
	}
	
	
	public void turnPSMLRight() throws IllegalArgumentException {

		IIterator it = objects.getIterator();
		while(it.hasNext())
		{
			GameObject o = (GameObject) it.getNext();
			
			if(o instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip) o;
				ps.getMissileLauncher().Steer(15);
				System.out.println("Turning missile launcher");
				//System.out.println(ps.toString());
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
		
	
	}
	
	
	public void turnPSMLLeft() throws IllegalArgumentException {

		
		IIterator it = objects.getIterator();
		while(it.hasNext())
		{
			GameObject o = (GameObject) it.getNext();
			
			if(o instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip) o;
				ps.getMissileLauncher().Steer(-15);
				
				System.out.println("Turning missile launcher");
				//System.out.println(ps.toString());
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
	}
	
	
	public void turnShipLeft() {

		IIterator iter = objects.getIterator();
		while(iter.hasNext()) {
	
			GameObject obj = (GameObject) iter.getNext();
			if(obj instanceof PlayerShip) {
				((PlayerShip) obj).Steer(-25);;
				System.out.println("Playership tuning left");
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
		System.out.println("Error");	
		
		
	}
	
	public void speedUpShip() 
	{
//		for(int i = 0; i < store.size(); i++)
//			
//		{
//			if(store.get(i) instanceof PlayerShip) {
//			PlayerShip ps = (PlayerShip) store.elementAt(i);
//			//if(ps.getSpeed() == 0)
//				ps.setSpeed(ps.getSpeed() + 1);
//				//ps.move();
//			System.out.println("Increasing speed");
//			this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//			}
//		}
		
		IIterator iter = objects.getIterator();
		while(iter.hasNext()) {
			int index = iter.current();
			GameObject obj = (GameObject) iter.getNext();
			if(obj instanceof PlayerShip) {
				((PlayerShip) obj).incSpeed();
				System.out.println("PlayerShip speed increased to " + ((MovableGameObject) obj).getSpeed());
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
		System.out.println("Error");
	}
		
	
	
	public void slowUpShip() 
	{
//		for(int i = 0; i < store.size(); i++)
//		{
//			if(store.get(i) instanceof PlayerShip) {
//			PlayerShip ps = (PlayerShip) store.elementAt(i);
//			//if(ps.getSpeed() == 0)
//				ps.setSpeed(ps.getSpeed() - 1);
//				//ps.move();
//			System.out.println("Decreasing speed");
//			this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//			}
//		}
		
		IIterator iter = objects.getIterator();
		while(iter.hasNext()) {
			
			GameObject obj = (GameObject) iter.getNext();
			if(obj instanceof PlayerShip) {
				((PlayerShip) obj).deSpeed();
				System.out.println("PlayerShip speed increased to " + ((MovableGameObject) obj).getSpeed());
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
		System.out.println("There exists no playership to increase speed");
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
//		for(int i = 0; i < store.size(); i++) 
//		{
//			if(store.get(i) instanceof PlayerShip) {
//			PlayerShip ps = (PlayerShip) store.elementAt(i);
//			//if(ps.getDirection() == 0)
//				//ps.setDirection(ps.getDirection() + 1);
//			ps.Steer(-1);
//			System.out.println("Turn direction of ship");
//			this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//			}
//			
//		}
		
		IIterator iter = objects.getIterator();
		while(iter.hasNext()) {
			int index = iter.current();
			GameObject obj = (GameObject) iter.getNext();
			if(obj instanceof PlayerShip) {
				((PlayerShip) obj).Steer(25);;
				System.out.println("Playership turning right");
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
		System.out.println("Error");	
	}
	
	public void reSupply() {

		IIterator it = objects.getIterator();
		while(it.hasNext()) {
		GameObject o = (GameObject) it.getNext();
		if(o instanceof PlayerShip && this.getMissileCount() >= 0)
		{
			PlayerShip ps = (PlayerShip) o;
			if(getMissileCount() == 10)
			{
				System.out.println("Max Missiles");
			}
			else {
				//ps.setMissileCount(10);
				setMCount(10);
				System.out.println("Missiles Reloaded");
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
			}
			return;
		}
		}
		System.out.println("Error");
		
	}
	
	
	
	public void playerShipMissileKillAsteroid() //player ship destroys asteroid 
    {
  
		
		if(p == 1 && a > 0) {
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof Missile) {
			
				it.remove(i);
				
				this.playerScore += 1;
				
				IIterator it2 = objects.getIterator();
				while(it2.hasNext()) {
					int i2 = it2.current();
					GameObject o2 = (GameObject) it2.getNext();
					if(o2 instanceof Asteroid) {
						it2.remove(i2);
						a--;
						System.out.println("PlayerShip Destroyed Asteroid");
						this.setChanged();
						this.notifyObservers(new GameWorldProxy(this));
						return;
					}
				}
			}
		}
		System.out.println("Error");
    }
    }

	
	
	
	
	public void removeMissileAndPS() //NPS missile destroys player ship
    {
		if(p == 1) {
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int iMiss = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof Missile) {
                if(((Missile) o).getOwner() instanceof NonPlayerShip) {
                  	it.remove(iMiss);
            		IIterator it2 = objects.getIterator();
            		while(it2.hasNext()) {
            			int iPS = it2.current();
            			GameObject o2 = (GameObject) it2.getNext();
            			if(o instanceof PlayerShip) {
                  			if(this.playerLives > 0) {
                  				it.remove(iPS);
                  				p = 0;
                            	System.out.println("PlayerShip was killed");
                        		this.setChanged();
                        		this.notifyObservers(new GameWorldProxy(this));
                            	return;
                        	}else {
                        		it2.remove(iPS);
        
                        		return;
                        	}
                  		}
            		}
                }
			}
            }    
		
    	System.out.println("Error");	
		}
		
 }
	
	public void removeMissileAndNPS() throws IllegalArgumentException 
    {   
		
		if(a == 1 && non > 0) {
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
            if(o instanceof Missile) {
                if(((Missile) o).getOwner() instanceof PlayerShip) {
                	
                	//((Missile) o).getOwner().decrementMissile();
                	this.playerScore += 1;
                  	it.remove(i);
            		IIterator it2 = objects.getIterator();
            		while(it2.hasNext()) {
            			int i2 = it2.current();
            			GameObject o2 = (GameObject) it2.getNext();
            			if(o2 instanceof NonPlayerShip) {
                    		it2.remove(i2);
                    		non--;
                    		System.out.println("NonPlayerShip destroyed by Missile");
                    		this.setChanged();
                    		this.notifyObservers(new GameWorldProxy(this));
                    		return;
                    	}
            		}
                 }
            } 
		}
    	System.out.println("Error");
    	return;
	}
    }
    	//else {
//    	System.out.println("Either PlayerShip,NonplayerShip,NonPlayerShip's missile does not exist");
//	}
		
		
		
		
   // }
	
	
	public void removeAstAndPS() // asteroid crashes into player ship
    {

		if(a > 0 && p == 1) {
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int iPS = it.current();
			GameObject o = (GameObject) it.getNext();
			 if(o instanceof PlayerShip) {
	            	if(this.playerLives > 0) {
	            		
	            		this.playerLives--;
	            		
	            		it.remove(iPS);
	            		p = 0;
	                	System.out.println("Playership is destroyed by Asteroid.");
	            		this.setChanged();
	            		this.notifyObservers(new GameWorldProxy(this));
	            	}else {
	            		
	            		it.remove(iPS);
	            		p = 0;
	            		this.setChanged();
	            		this.notifyObservers(new GameWorldProxy(this));
	            		
	            	}
	                break;
	            }
		}
		IIterator it2 = objects.getIterator();
		while(it2.hasNext()) {
			int iAst = it2.current();
			GameObject o2 = (GameObject) it2.getNext();
            if(o2 instanceof Asteroid) {
                it2.remove(iAst);
                a--;
        		this.setChanged();
        		this.notifyObservers(new GameWorldProxy(this));
                break;
            }
		}
		}
	}


	
	public void removeNPSAndPS() //player ship and non player ship crash
    { 
		if(a == 1 && non > 0) {
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int iPS = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof PlayerShip) {
            	if(this.playerLives > 0) {
            		this.playerLives--;
            		it.remove(iPS);
            		p = 0;
                	System.out.println("Playership is destroyed by NonPlayerShip");
            		this.setChanged();
            		this.notifyObservers(new GameWorldProxy(this));
            	}else {
            		
            		it.remove(iPS);
            		
            		this.setChanged();
            		this.notifyObservers(new GameWorldProxy(this));
            		
            	}
                break;
            }
		}

		IIterator it2 = objects.getIterator();
		while(it2.hasNext()) {
			int iNPS = it2.current();
			GameObject o2 = (GameObject) it2.getNext();
           
			if(o2 instanceof NonPlayerShip) {
                it2.remove(iNPS);
                non--;
        		this.setChanged();
        		this.notifyObservers(new GameWorldProxy(this));
                break;
            }
		}
	}
    }	
		
    
	
	
	
	public void removeAstAndNPS() //asteroid hits non player ship
    {
        if(a > 0 && non > 0) {
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof Asteroid) {
				it.remove(i);
				a--;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				break;
			}
		}
		IIterator it2 = objects.getIterator();
		while(it2.hasNext()) {
			int i2 = it2.current();
			GameObject o2 = (GameObject) it2.getNext();
			if(o2 instanceof NonPlayerShip) {
				it2.remove(i2);
				non--;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				break;
			}
		}
		System.out.println("NonPlayer Ship was destroyed by an Asteroid");
        }
        }
	
	
	

	//asteroids crash into each other
	public void removeAsteroids() 
	{

		if(a > 1) {
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof Asteroid) {
				it.remove(i);
				a--;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				break;
			}
		}
		IIterator it2 = objects.getIterator();
		while(it2.hasNext()) {
			int i2 = it2.current();
			GameObject o2 = (GameObject) it2.getNext();
			if(o2 instanceof Asteroid) {
				it2.remove(i2);
				a--;
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				break;
			}
		}
		System.out.println("Asteroids collided.");
		return;
		}
	}
	
	
	
	
	public void printMap() {
		IIterator it = objects.getIterator();
		GameObject o;
		while(it.hasNext()) {
			o = (GameObject) it.getNext();
			System.out.println(o.toString());
		}

		
	}
	
	
	
	public void printDisplay() throws IllegalArgumentException {
		
		IIterator iter = objects.getIterator();
		while(iter.hasNext()) {
			Object obj = iter.getNext();
			if(obj instanceof PlayerShip) {
				System.out.println( "Current Score=" + this.playerScore +
						" # of missile in ship=" + getMissileCount() + 
						" elapased time=" + this.clock + 
						" Number of lives=" + ((PlayerShip) obj).getLives());
			}
		}

		
	}


	public int getPlayerScore() {
		// TODO Auto-generated method stub
		return this.playerScore;
	}


	public void setMCount(int m)
	{
		numPSMissiles = m;
	}
	
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return this.numPSMissiles;
	}
	
	public void setNPSCount(int m)
	{
		numNPSMissiles = m;
	}
	
	public int getNPSCount()
	{
		return this.numNPSMissiles;
	}
	
	
	public int getPlayerLives() {
		return this.playerLives;
	}


	public int getElapseTime() {
		// TODO Auto-generated method stub
		return this.elapsedGameTime;
	}
	
	
	public void quit()
	{
		System.exit(0);
	}


	@Override
	public void setSound(boolean s) {
		// TODO Auto-generated method stub
		this.soundOn = s;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}
	
	public boolean getSound()
	{
		return this.soundOn;
		
	}


	//@Override
//	public IIterator getObjectIterator()  
//	{
//		//throws NullPointerException {
//		// TODO Auto-generated method stub
//		return objects.getIterator();
//
//		
//	}


	@Override
	public void setHeight(int h) {
		// TODO Auto-generated method stub
		this.gheight = h;
		
	}

	public double getHeight()
	{
		return this.gheight;
	}

	@Override
	public void setWidth(int w) {
		// TODO Auto-generated method stub
		this.gwidth = w;
		
	}
	
	public double getWidth()
	{
		return this.gwidth;
	}
	@Override
	public IIterator getObjectIterator() {
		// TODO Auto-generated method stub
		return objects.getIterator();
	}


	@Override
	public SpaceCollection getCollection() {
		// TODO Auto-generated method stub
		return this.objects;
	}


//	@Override
//	public IDrawable draw() {
//		// TODO Auto-generated method stub
//		//return this.draw();
//		return draw();
//	}

	static public int getGameWidth() {
		return gwidth;
	}
	
	/**
	 * 
	 */
	static public int getGameHeight() {
		return gheight;
	}
	
	
	static public void setGameWidth(int w) 
	{ 
		gwidth = w; 
	}
	static public void setGameHeight(int h)
	{ 
		gheight = h;
	}
	
	
	
	

}
