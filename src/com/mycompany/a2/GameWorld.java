package com.mycompany.a2;

import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;




public class GameWorld extends Observable  implements IGameWorld{
	
	
	Random rand = new Random();
	public Vector<GameObject> store = new Vector<GameObject>();
	private double gwidth = 1024;
	private double gheight = 768;
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
	private PlaySound gameSound;
	private int acc;
	private int pcc;
	
	
	
	public void addNewAsteroid() {
		//Asteroid asteroid = new Asteroid();
		//store.add(asteroid);
		objects.add(new Asteroid());
		acc--;
		System.out.println("A new Asteroid will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
 	
	
	public void newSpaceStation() {
		//SpaceStation b = new SpaceStation();
		//store.add(b);
		objects.add(new SpaceStation());
		System.out.println("A new space station will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}
	
	public void newPS() {
		if(s == null) {
		s = new PlayerShip();
		
		store.add(s);
		this.pcc = 1;
		objects.add(s);
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
		//store.add(y);
		objects.add(y);
		System.out.println("A new NPS will be created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void init() {
	playerScore = 0;
	playerLives = 3;
	clock =0;
	soundOn = false;
	numPSMissiles = 10;
	objects = new SpaceCollection();
	numNPSMissiles = 4;
	acc = 0;
	pcc = 0;
	
	
		
	}	
	
	
	public void fireMissile () throws IllegalArgumentException {
			
//		for(int i = 0 ; i < store.size() ; i++) {
//			if(store.elementAt(i) instanceof PlayerShip) {
//				PlayerShip ps = (PlayerShip) store.elementAt(i);
//				if(ps.getMissileCount() > 0) { 
//					ps.setMissileCount(ps.getMissileCount() -1);//Dec missile count by 1
//				Missile ms1 = new Missile(ps.getColor(), ps.getLocationX(), ps.getLocationY(), ps.getSpeed(), ps.getDirection(), ps);
//				store.add(ms1);
//				System.out.println("PlayerShip has fired a Missile!");
//				this.setChanged();
//				this.notifyObservers(new GameWorldProxy(this));
//				return;
//				}else {
//					System.out.println("PlayerShip has no more Missiles!");
//				}
//			}
//
//		}

		
		//this.notifyObservers(new GameWorldProxy(this));
		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
		GameObject o = (GameObject) it.getNext();			
			
			if(o instanceof PlayerShip) {
				
				if(getMissileCount() > 0) { 
					setMCount(getMissileCount() -1);//Dec missile count by 1
				
				//Missile ms1 = new Missile(o.getColor(), o.getLocationX(), o.getLocationY(), ((PlayerShip) o).getSpeed(), ((PlayerShip) o).getDirection(), ((PlayerShip) o));
				
				objects.add(new Missile(((PlayerShip) o)));

				
				System.out.println(getMissileCount() + " missiles left");
				System.out.println("PlayerShip has fired a Missile!");
				
				
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				
				
				}
				else {
					System.out.println("PlayerShip has no more Missiles!");
				}
				
			}
			return;
			}
		return;
				
		}
	
	
	
	public void launchMissile() throws IllegalArgumentException{
//		
//		for(int i = 0 ; i < store.size() ; i++) {
//			if(store.elementAt(i) instanceof NonPlayerShip) {
//				NonPlayerShip nps = (NonPlayerShip) store.elementAt(i);
//				if(nps.getMissileCount() > 0)  {
//					nps.setMissileCount(nps.getMissileCount() -1);
//				Missile ms1 = new Missile(nps.getColor(), nps.getLocationX(), nps.getLocationY(),  nps.getSpeed(), nps.getDirection(), nps);
//				store.add(ms1);
//				System.out.println("NonPlayerShip has fired a Missile!");
//				this.setChanged();
//				this.notifyObservers(new GameWorldProxy(this));
//				return;
//			
//			}else {
//				System.out.println("NonPlayerShip has no more Missiles!");
//			}
//			}
//		}
		
		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
		GameObject o = (GameObject) it.getNext();			
			
			if(o instanceof NonPlayerShip) {
				
				if(getNPSCount() > 0) { 
					setNPSCount(getNPSCount() -1);//Dec missile count by 1
				
				Missile ms1 = new Missile(((NonPlayerShip) o));
				
				objects.add(ms1);
				
				
				System.out.println(getNPSCount() + " missiles left");
				System.out.println("NonPlayerShip has fired a Missile!");
				
				
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				
				
				}
				else {
					System.out.println("NonPlayerShip has no more Missiles!");
				}
				
			}
			}
		
		
		
	}
	
	
	
	public void tick() throws IllegalArgumentException{
//		clock++;
//		if(store.size() > 0) {
//			//for(int i = 0; i < (store.size() - 1); i++) {
//				for(int i = store.size() - 1; i >= 0; i--) {
//				if(store.get(i) instanceof Movable) {
//					Movable curMovableObj = (Movable) store.get(i);
//					curMovableObj.move(); 
//					
//				}
//				if(store.get(i) instanceof Missile) 
//				{
//					Missile curMissile = (Missile) store.get(i);
//					int fuel = curMissile.getFuel();
//					if(fuel > 1) 
//						curMissile.setFuel(fuel - 1);
////					else {
////						curMissile = null;
////						store.remove(i);
////					}
//				}
//				if(store.get(i) instanceof SpaceStation)
//				{
//					SpaceStation spc = (SpaceStation) store.get(i);
//					if(clock % spc.getBlinkRate() == 0)
//					{
//						if(spc.getLight())
//							spc.setLight(false);
//						else 
//							spc.setLight(true);
//					}
//				}
//				
//			}
//		}
//		System.out.println("Tick");
//		this.setChanged();
//		this.notifyObservers(new GameWorldProxy(this));
//		
//		//clock++;
//	}
	
//	

		IIterator iter = objects.getIterator();
		
		while(iter.hasNext()) {
			
			int i = iter.current();
			GameObject obj = (GameObject) iter.getNext();
			
		
			if(obj instanceof Missile && ((Missile) obj).getFuel() > 1 ) {
				iter.remove(i);
				
			
			}else if(obj instanceof Missile && ((Missile) obj).getFuel() != 1) {
				((Missile) obj).setFuel(fuel - 1);;
			
			}else if(!(obj instanceof FixedGameObject)) {
				((MovableGameObject) obj).move();
			
			}else {
				continue;
			}
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
		
		clock++;
	}

	
	
	public void jump () throws IllegalArgumentException
	{	
		
//		for(int i = 0; i < store.size(); i++)
//		{
//		if(store.elementAt(i) instanceof PlayerShip) 
//			{
//		PlayerShip ps = (PlayerShip) store.elementAt(i);
//		//ps.setLocation(512, 384);
//		ps.reset();
//		System.out.println("Ship jumped through hyperspace");
//		this.setChanged();
//		this.notifyObservers(new GameWorldProxy(this));
//			}
//		 	}
		
		IIterator i = objects.getIterator();
		while(i.hasNext())
		{
			int index = i.current();
			GameObject o = (GameObject) i.getNext();
			if(o instanceof PlayerShip)
			{
				((PlayerShip) o).reset();
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				System.out.println("Jumped through hyperspace");
				return;
				
			}
		}
		
		System.out.println("Error");
	}
	
	
	public void turnPSMLRight() throws IllegalArgumentException {
//		for(int i = 0; i < store.size(); i++) 
//		{
//			if(store.get(i) instanceof PlayerShip) {
//			PlayerShip ps = (PlayerShip) store.elementAt(i);
//			//if(ps.getMissileLauncher().getDirection() == 0) {
//				//ps.getMissileLauncher().setDirection(-90);
//				ps.changeLauncherDirection(1);
//				System.out.println("Turning direction of missile launcher");
//				this.setChanged();
//				this.notifyObservers(new GameWorldProxy(this));
//				//}
//				//else 
//			}
//					//System.out.println("Can't turn missile");
//		}
		IIterator it = objects.getIterator();
		while(it.hasNext())
		{
			GameObject o = (GameObject) it.getNext();
			
			if(o instanceof PlayerShip)
			{
				PlayerShip ps = new PlayerShip();
				ps.changeLauncherDirection(1);
				System.out.println("Turning missile launcher");
				//System.out.println(ps.toString());
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
			}
		}
		
	
	}
	
	
	public void turnPSMLLeft() throws IllegalArgumentException {
//		for(int i = 0; i < store.size(); i++) 
//		{
//			if(store.get(i) instanceof PlayerShip) {
//			PlayerShip ps = (PlayerShip) store.elementAt(i);
//			//if(ps.getMissileLauncher().getDirection() == 0) {
//				//ps.getMissileLauncher().setDirection(-90);
//				ps.changeLauncherDirection(-1);
//				System.out.println("Turning direction of missile launcher");
//				this.setChanged();
//				this.notifyObservers(new GameWorldProxy(this));
//				//}
//				//else
//			}
//					//System.out.println("Can't turn missile");
//		}
		
		IIterator it = objects.getIterator();
		while(it.hasNext())
		{
			GameObject o = (GameObject) it.getNext();
			
			if(o instanceof PlayerShip)
			{
				PlayerShip ps = new PlayerShip();
				ps.changeLauncherDirection(-1);
				System.out.println("Turning missile launcher");
				//System.out.println(ps.toString());
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
			}
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
	
//	public PlayerShip findPlayer()
//	{
//		int i = -1;
//		PlayerShip temp = null;
//		return temp;
//	}
	
	public void turnShipLeft() {
//		for(int i = 0; i < store.size(); i++) 
//		{
//			if(store.get(i) instanceof PlayerShip) {
//			PlayerShip ps = (PlayerShip) store.elementAt(i);
//			//(ps.getDirection() == 0)
//				//ps.setDirection(ps.getDirection() - 1);
//			ps.Steer(1);
//		System.out.println("Turning direction of ship");
//		this.setChanged();
//		this.notifyObservers(new GameWorldProxy(this));
//			}
//			}
		
		
		IIterator iter = objects.getIterator();
		while(iter.hasNext()) {
			int index = iter.current();
			GameObject obj = (GameObject) iter.getNext();
			if(obj instanceof PlayerShip) {
				((PlayerShip) obj).Steer(1);;
				System.out.println("Playership turned left by 1");
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
			int index = iter.current();
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
				((PlayerShip) obj).Steer(-1);;
				System.out.println("Playership turned left by 1");
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}
		}
		System.out.println("Error");	
	}
	
	public void reSupply() {
//		if(s instanceof PlayerShip) {
//			if(getMissileCount() == 10)
//			//if(numPSMissiles == 10)
//			{
//				System.out.println("Missiles already max");
//			}
//			else {
//				
// 			setMCount(10);
//			//numPSMissiles = 10;
//			System.out.println("Missiles Reloaded");
//			this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//			}
//			
//		}
//		else {
//			System.out.println("Can't resupply");
//		}
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
//        boolean asteroidExists = false;
//        boolean missileExists = false;
//        Missile ms = null;
//        Asteroid ast = null;
//        
//        for (int i = 0; i <store.size() && (!asteroidExists || !missileExists); i++)
//        {
//            if ((store.elementAt(i) instanceof Asteroid) && !asteroidExists)
//            {
//                ast = (Asteroid) store.elementAt(i);
//                asteroidExists = true;
//            }        
//            
//            if ((store.elementAt(i) instanceof Missile) && !missileExists)
//            {
//                ms = (Missile) store.elementAt(i);
//                missileExists = true;
//            }        
//        }
//        
//        if(missileExists && asteroidExists)
//        {
//            store.remove(ast);
//            store.remove(ms);
//            //ps.setPlayerScore(ps.PlayerScore() + 1);
//            playerScore += 1;
//            
//            System.out.println("Player has destroyed an Asteroid with a missile! Score increased by 1!");
//            this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//        }
//        else
//            System.out.println("Error: A missile or Asteroid doesn't exist.");  
		
		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof Missile) {
			
				it.remove(i);
			//	SpaceCollection.delete(o);
				this.playerScore += 1;
				IIterator it2 = objects.getIterator();
				while(it2.hasNext()) {
					int i2 = it2.current();
					GameObject o2 = (GameObject) it2.getNext();
					if(o2 instanceof Asteroid) {
						it2.remove(i2);
						acc--;
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
//	else {
//		System.out.println("Error : Asteroid or Playership or PlayerMissile does not exists");
//	}
//		
		
//}
	
	
	
	
	public void removeMissileAndPS() //NPS missile destroys player ship
    {
//        boolean psExists = false;
//        boolean missileExists = false;
//        Missile ms = null;
//        PlayerShip ps = null;
//        
//        for (int i = 0; i < store.size() && (!psExists || !missileExists); i++)
//        {
//            if ((store.elementAt(i) instanceof PlayerShip) && !psExists)
//            {
//                ps = (PlayerShip) store.elementAt(i);
//                psExists = true;
//            }        
//            
//            if ((store.elementAt(i) instanceof Missile) && !missileExists)
//            {
//                ms = (Missile) store.elementAt(i);
//                missileExists = true;
//            }        
//        }
//        
//        if(missileExists && psExists)
//        {
//            store.remove(ps);
//            store.remove(ms);
//            //this.setPlayerLives(this.getPlayerLives() - 1);
//          // ps.setLives(ps.getLives() - 1);
//            playerLives -= 1;
//            System.out.println("Player has lost a life! Player Lives Remaining: " +  playerLives);
//            this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//        }
//        else
//            System.out.println("Error: A missile or Player Ship doesn't exist.");  
		
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
                  				pcc = 0;
                            	System.out.println("PlayerShip was destroyed by NPS's Missile");
                        		this.setChanged();
                        		this.notifyObservers(new GameWorldProxy(this));
                            	return;
                        	}else {
                        		it2.remove(iPS);
                        		System.out.println("Game Over");
                        		return;
                        	}
                  		}
            		}
                }
            }    
		}
    	System.out.println("Error");	
		
		
		
		
		
		
    }
	
	public void removeMissileAndNPS() throws IllegalArgumentException //PS missile destorys NPS
    {
//        boolean npsExists = false;
//        boolean missileExists = false;
//        Missile ms = null;
//        NonPlayerShip nps = null;
//        
//        for (int i = 0; i < store.size() && (!npsExists || !missileExists); i++)
//        {
//            if ((store.elementAt(i) instanceof NonPlayerShip) && !npsExists)
//            {
//                nps = (NonPlayerShip) store.elementAt(i);
//                npsExists = true;
//            }        
//            
//            if ((store.elementAt(i) instanceof Missile) && !missileExists)
//            {
//                ms = (Missile) store.elementAt(i);
//                missileExists = true;
//            }        
//        }
//        
//        if(missileExists && npsExists)
//        {
//            store.remove(nps);
//            store.remove(ms);
//            //this.setPlayerLives(this.getPlayerLives() + 1);
//            playerLives += 1;
//            playerScore += 1;
//            System.out.println("Player destroyed Non Player Ship. Update Score: " + playerLives);
//            this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//        }
//        else
//            System.out.println("Error: A missile or NonPlayer Ship doesn't exist.");   
		
		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
            if(o instanceof Missile) {
                if(((Missile) o).getOwner() instanceof PlayerShip) {
                	//Remove missile and decrease missile count for PS 
                	((Missile) o).getOwner().decrementMissile();
                	this.playerScore += 1;
                  	it.remove(i);
            		IIterator it2 = objects.getIterator();
            		while(it2.hasNext()) {
            			int i2 = it2.current();
            			GameObject o2 = (GameObject) it2.getNext();
            			if(o2 instanceof NonPlayerShip) {
                    		it2.remove(i2);
                    		//npsCount--;
                    		System.out.println("NonPlayerShip was destroyed by PlayerShip Missile");
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
    	//else {
//    	System.out.println("Either PlayerShip,NonplayerShip,NonPlayerShip's missile does not exist");
//	}
		
		
		
		
   // }
	
	
	public void removeAstAndPS() // asteroid crashes into player ship
    {
//        boolean psExists = false;
//        boolean astExists = false;
//        Asteroid ast = null;
//        PlayerShip ps = null;
//        
//        for (int i = 0; i < store.size() && (!psExists || !astExists); i++)
//        {
//            if ((store.elementAt(i) instanceof PlayerShip) && !psExists)
//            {
//                ps = (PlayerShip) store.elementAt(i);
//                psExists = true;
//            }        
//            
//            if ((store.elementAt(i) instanceof Asteroid) && !astExists)
//            {
//                ast = (Asteroid) store.elementAt(i);
//                astExists = true;
//            }        
//        }
//        
//        if(astExists && psExists)
//        {
//            store.remove(ps);
//            store.remove(ast);
//            //this.setPlayerLives(this.getPlayerLives() - 1);
//            playerLives -= 1;
//            System.out.println("Player has lost a life! Player Lives Remaining: " + playerLives);
//            this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//        }
//        else
//            System.out.println("Error: An asteroid or Player Ship doesn't exist."); 
		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int iPS = it.current();
			GameObject o = (GameObject) it.getNext();
			 if(o instanceof PlayerShip) {
	            	if(this.playerLives > 0) {
	            		
	            		this.playerLives--;
	            		
	            		it.remove(iPS);
	            		pcc = 0;
	                	System.out.println("Playership is destroyed by Asteroid.");
	            		this.setChanged();
	            		this.notifyObservers(new GameWorldProxy(this));
	            	}else {
	            		
	            		it.remove(iPS);
	            		pcc = 0;
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
                acc--;
        		this.setChanged();
        		this.notifyObservers(new GameWorldProxy(this));
                break;
            }
		}
	}
//		else {
//		System.out.println("Either PlayerShip or Asteroid does not exist");
//	}
		
    //}
	

	
	public void removeNPSAndPS() //player ship and non player ship crash
    {
//        boolean psExists = false;
//        boolean npsExists = false;
//        NonPlayerShip nps = null;
//        PlayerShip ps = null;
//        
//        for (int i = 0; i < store.size() && (!psExists || !npsExists); i++)
//        {
//            if ((store.elementAt(i) instanceof PlayerShip) && !psExists)
//            {
//                ps = (PlayerShip) store.elementAt(i);
//                psExists = true;
//            }        
//            
//            if ((store.elementAt(i) instanceof NonPlayerShip) && !npsExists)
//            {
//                nps = (NonPlayerShip) store.elementAt(i);
//                npsExists = true;
//            }        
//        }
//        
//        if(npsExists && psExists)
//        {
//            store.remove(ps);
//            store.remove(nps);
//            //this.setPlayerLives(this.getPlayerLives() - 1);
//            playerLives -= 1;
//            System.out.println("PS collided with a NPS! Player has lost a life! Player Lives Remaining: " + playerLives);
//            this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//        }
//        else
//            System.out.println("Error: A Non Player Ship or Player Ship doesn't exist.");  
		
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int iPS = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof PlayerShip) {
            	if(this.playerLives > 0) {
            		this.playerLives--;
            		it.remove(iPS);
            		pcc = 0;
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
                
        		this.setChanged();
        		this.notifyObservers(new GameWorldProxy(this));
                break;
            }
		}
	}
		
		
    
	
	
	
	public void removeAstAndNPS() //asteroid hits non player ship
    {
//        boolean npsExists = false;
//        boolean astExists = false;
//        Asteroid ast = null;
//        NonPlayerShip nps = null;
//        
//        for (int i = 0; i < store.size() && (!npsExists || !astExists); i++)
//        {
//            if ((store.elementAt(i) instanceof NonPlayerShip) && !npsExists)
//            {
//                nps = (NonPlayerShip) store.elementAt(i);
//                npsExists = true;
//            }        
//            
//            if ((store.elementAt(i) instanceof Asteroid) && !astExists)
//            {
//                ast = (Asteroid) store.elementAt(i);
//                astExists = true;
//            }        
//        }
//        
//        if(astExists && npsExists)
//        {
//            store.remove(nps);
//            store.remove(ast);
//            System.out.println("An asteroid and a Non Player Ship Collided! Both are Destroyed!");    
//            this.setChanged();
//			this.notifyObservers(new GameWorldProxy(this));
//        }
//        else
//            System.out.println("Error: An asteroid or Non Player Ship doesn't exist.");    
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof Asteroid) {
				it.remove(i);
				
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
				
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				break;
			}
		}
		System.out.println("NonPlayer Ship was destroyed by an Asteroid");
	}
	
	
	

	//asteroids crash into each other
	public void removeAsteroids() 
	{
//	 boolean astro1 = false;
//	 boolean astro2 = false;
//	 int ast1 = 0;
//	 int ast2 = 0;
//		
//		for(int i = 0; i < store.size(); i++ ) {
//			if(store.get(i) instanceof Asteroid && astro1 != false) 
//			{
//				ast1 = i;
//				astro1 = true;
//			}
//			if (store.get(i) instanceof Asteroid && astro2 != false)
//			{
//				ast2 = i;
//				astro2 = true;
//			}
//			
//		}
//		
//		if(astro2 != true && astro1 != true) 
//		{
//			
//			
//				store.remove(ast2);
//				store.remove(ast1);
//				System.out.println("Both asteroids destroyed");
//				this.setChanged();
//				this.notifyObservers(new GameWorldProxy(this));
//		}
//		else 
//			System.out.println("Error or Asteroid don't exist");
		IIterator it = objects.getIterator();
		while(it.hasNext()) {
			int i = it.current();
			GameObject o = (GameObject) it.getNext();
			if(o instanceof Asteroid) {
				it.remove(i);
				
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
				
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				break;
			}
		}
		System.out.println("Asteroids Collided and both were destroyed.");
		return;
	}
	
	
	
	public void printMap() {
		//String map = null;
//		for(GameObject i : store) {
//			//map = (i.toString() + "\n");
//			if(i instanceof Missile) {
//				if( ((Missile) i).getOwner()      instanceof PlayerShip) {
//					System.out.println(((Missile)i).missileString(true));
//				}else {
//					System.out.println(((Missile)i).missileString(false));
//				}
//			}else {
//				System.out.println(i.toString());
//			}
//		}
		
		IIterator it = objects.getIterator();
		GameObject o;
		while(it.hasNext()) {
			o = (GameObject) it.getNext();
			System.out.println(o.toString());
		}

		
	}
	
	
	
	public void printDisplay() throws IllegalArgumentException {
//		for(int i = 0; i < store.size(); i++)
//		{
//			if(store.elementAt(i) instanceof PlayerShip) {
//				System.out.println("PlayerShip: playerScore = " + this.playerScore +" Number of Missiles= " + (((Ship) store.get(i)).getMissileCount())
//						+ " Number of lives = " + (((PlayerShip) store.get(i)).getLives())
//						);
//						
//			}
//		}
		
		IIterator iter = objects.getIterator();
		while(iter.hasNext()) {
			Object obj = iter.getNext();
			if(obj instanceof PlayerShip) {
				System.out.println( "Current Score=" + this.playerScore +
						" Number of missile in ship=" + ((Ship) obj).getMissileCount() + 
						" Current elapased time=" + this.clock + 
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




	
	
	

}
