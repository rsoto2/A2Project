package com.mycompany.a2;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.*;
import com.codename1.charts.util.ColorUtil;

import java.lang.String;
import java.util.Observer;


public class Game extends Form implements Runnable{
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	private GameButton npsbutton, quitbutton, asteroid, ssbutton, shipbutton, missilebutton, hyperbutton;
	
	private AddAsteroidCommand addastro;
	private AddStationCommand addstation;
	private AddShipCommand addShip;
	private IncreaseSpeedCommand iSpeed;
	private DecreaseSpeedCommand dSpeed;
	private TurnLeftCommand tl;
	private TurnRightCommand rl;
	private FireMissileCommand m;
	private HyperSpaceCommand h;
	private ResupplyCommand r;
	private QuitGameCommand q;
	private NewGameCommand n;
	private AboutGameCommand about;
	private SaveGameCommand save;
	private UndoGameCommand undo;
	private AddNPSCommand nps;
	private MissileLeftCommand missileL;
	private MissileRightCommand missileR;
	private NPSMissileCommand NPSmissile;
	private PSMissileHitsAsteroidCommand psAst;
	private PSMissileHitsNPSCommand psNPS;
	private NPSMissileHitsPSCommand npsPS;
	private PSHitsAsteroidCommand psHitAst;
	private PSHitsNPSCommand psHitNps;
	private AsteroidHitAsteroidCommand aa;
	private AsteroidHitsNPSCommand astNPS;
	private TickCommand tick;
	private SoundCommand sound;
	private PlaySound gameSound;
	
	
	
	private Container leftButtons;
	
	
	
	
	
	public Game()  {
		gw = new GameWorld();
		mv = new MapView(gw);
		pv = new PointsView(gw);
		gw.addObserver(mv);
		gw.addObserver(pv);
		gw.init();
		//this.show();

		setLayout(new BorderLayout());
//		this.add(BorderLayout.CENTER, mv);
//		this.add(BorderLayout.NORTH, pv);
		
		
		leftButtons = new Container();
		leftButtons.getAllStyles().setBgTransparency(0);
		leftButtons.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		leftButtons.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		leftButtons.getAllStyles().setBgColor(ColorUtil.GREEN);

		

		//this.add(BorderLayout.WEST, leftButtons);
		

		//asteroidbutton
		asteroid = new GameButton("Asteroid");
		asteroid.getAllStyles().setBgTransparency(255);
		asteroid.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		asteroid.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addastro = new AddAsteroidCommand(gw);
		asteroid.setCommand(addastro);
		this.addKeyListener('a', addastro);
		leftButtons.addComponent(asteroid);
		asteroid.setFocusable(false);
		
		
		//nonplayershipbutton
		npsbutton = new GameButton("NPS");
		npsbutton.getAllStyles().setBgTransparency(255);
		npsbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		npsbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		nps = new AddNPSCommand(gw);
		npsbutton.setCommand(nps);
		this.addKeyListener('y', nps);
		leftButtons.addComponent(npsbutton);
		npsbutton.setFocusable(false);
		
		//stationbutton
		ssbutton = new GameButton("Station");
		ssbutton.getAllStyles().setBgTransparency(255);
		ssbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		ssbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addstation = new AddStationCommand(gw);
		ssbutton.setCommand(addstation);
		this.addKeyListener('b', addstation);
		leftButtons.addComponent(ssbutton);
		ssbutton.setFocusable(false);
		
		//shipbutton
		shipbutton= new GameButton("Ship");
		shipbutton.getAllStyles().setBgTransparency(255);
		shipbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		shipbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addShip = new AddShipCommand(gw);
		shipbutton.setCommand(addShip);
		this.addKeyListener('s', addShip);
		leftButtons.addComponent(shipbutton);
		shipbutton.setFocusable(false);
		
		//increase speed command
		iSpeed = new IncreaseSpeedCommand(gw);
		this.addKeyListener(-91, iSpeed);

		//decrease speed command
		dSpeed= new DecreaseSpeedCommand(gw);
		this.addKeyListener(-92, dSpeed);

		//turn direction of ship command; LEFT
		tl = new TurnLeftCommand(gw);
		this.addKeyListener(-93, tl);

		
		//turn direction of ship command; RIGHT
		rl= new TurnRightCommand(gw);
		this.addKeyListener(-94, rl);

		//missile button
		missilebutton = new GameButton("Fire Missile");
		missilebutton.getAllStyles().setBgTransparency(255);
		missilebutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		missilebutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		m = new FireMissileCommand(gw);
		missilebutton.setCommand(m);
		this.addKeyListener(-90, m);
		leftButtons.addComponent(missilebutton);
		missilebutton.setFocusable(false);
		
		//hyperbutton
		hyperbutton = new GameButton("HyperSpace");
		hyperbutton.getAllStyles().setBgTransparency(255);
		hyperbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		hyperbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		h = new HyperSpaceCommand(gw);
		hyperbutton.setCommand(h);
		this.addKeyListener('f', h);
		leftButtons.addComponent(hyperbutton);
		hyperbutton.setFocusable(false);
		
		//resupply missiles
		r = new ResupplyCommand(gw);
		this.addKeyListener('n', r);
		//turn launcher left
		missileL = new MissileLeftCommand(gw);
		this.addKeyListener('<', missileL);
		
		//turn launcher right
		missileR = new MissileRightCommand(gw);
		this.addKeyListener('>', missileR);
		
		//nps missile
		NPSmissile = new NPSMissileCommand(gw);
		this.addKeyListener('L', NPSmissile);
		//ps missile kills asteroid
		psAst = new PSMissileHitsAsteroidCommand(gw);
		this.addKeyListener('k', psAst);
		//ps missile kills nps
		psNPS = new PSMissileHitsNPSCommand(gw);
		this.addKeyListener('e', psNPS);
		//nps missile hits ps
		npsPS = new NPSMissileHitsPSCommand(gw);
		this.addKeyListener('E', npsPS);
		//PS hits asteroid
		psHitAst = new PSHitsAsteroidCommand(gw);
		this.addKeyListener('c', psHitAst);
		//ps hits NPS
		psHitNps = new PSHitsNPSCommand(gw);
		this.addKeyListener('h', psHitNps);
		//asteroid hits asteroid 
		aa = new AsteroidHitAsteroidCommand(gw);
		this.addKeyListener('x', aa);
		//asteroid hits NPS
		astNPS = new AsteroidHitsNPSCommand(gw);
		this.addKeyListener('I', astNPS);
		//tick
		tick = new TickCommand(gw);
		this.addKeyListener('t', tick);
		
		
		q = new QuitGameCommand(gw);
		this.addKeyListener('q', q);
		
//		this.add(BorderLayout.WEST, leftButtons);
//		
//		this.add(BorderLayout.CENTER, mv);
//		this.add(BorderLayout.NORTH, pv);
//		
//		this.show();
		//gw.init();
		//play();
		
		
	
		//toolbar menu
		Toolbar sideMenu = new Toolbar();
		Toolbar.setOnTopSideMenu(false);
		quitbutton = new GameButton("Quit");
		sideMenu.setUIID("ToolBar");
		sideMenu.getAllStyles().setBgTransparency(0);
		sideMenu.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.rgb(100, 0, 0)));
		sideMenu.getAllStyles().setBackgroundGradientStartColor(ColorUtil.GRAY);
		this.setToolbar(sideMenu);
		sideMenu.setTitle("Asteroid Game");
		sideMenu.getTitleComponent().getAllStyles().setFgColor(ColorUtil.BLUE);
		
		
		//Command newGame = new Command("Quit");
		q = new QuitGameCommand(gw);
		quitbutton.setCommand(q);
		this.addKeyListener('q', q);
		sideMenu.addCommandToLeftSideMenu(q);
		//sideMenu.addCommandToLeftSideMenu(newGame);
		
		about = new AboutGameCommand(gw);
		//this.addKeyListener(-1, about);
		sideMenu.addCommandToLeftSideMenu(about);
		
		n = new NewGameCommand(gw);
		//this.addKeyListener(-1, n);
		sideMenu.addCommandToLeftSideMenu(n);
		
		save = new SaveGameCommand(gw);
		//this.addKeyListener(-1,  save);
		sideMenu.addCommandToLeftSideMenu(save);
		
		undo = new UndoGameCommand(gw);
		//this.addKeyListener(-1, undo);
		sideMenu.addCommandToLeftSideMenu(undo);
		
		CheckBox s = new CheckBox();
		
		//Button sounds = new Button();
		
		s.setCommand(new SoundCommand(gw));
		
		//Sounds Button
		sideMenu.addComponentToLeftSideMenu(s);
		s.getAllStyles().setBgTransparency(255);
		s.getAllStyles().setBgColor(ColorUtil.GRAY);
		
		
		
		//gw.addObserver(mv);
	
		UITimer time = new UITimer(this);
		time.schedule(100, true, this);
		add(BorderLayout.WEST, leftButtons);
		
		add(BorderLayout.CENTER, mv);
		add(BorderLayout.NORTH, pv);
		run();
		this.show();
		//gameSound = new PlaySound("frogs.wav");
		//gameSound.play();
	
//		gw.init();
//		play();
//		quit();
	}





	@Override
	public void run() {
		// TODO Auto-generated method stub
		//int x = 1;
		gw.tick();
		//return;
	}
	

	
//	private void play() {
//		
//		Label myLabel = new Label("Enter a Command: ");
//		this.addComponent(myLabel);
//		final TextField myTextField = new TextField();
//		this.addComponent(myTextField);
//		this.show();
//		
//		myTextField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent evt) {
//				String sCommand = myTextField.getText().toString();
//				myTextField.clear();
//				if(!sCommand.isEmpty()) {
//				switch(sCommand.charAt(0)) {
//				case 'a': 
//					gw.addNewAsteroid();
//					break;
//				case 'y': 
//					gw.newNPS();
//					break;
//				case 'b':
//					gw.newSpaceStation();
//					break;
//				case 's':
//					gw.newPS();
//					break;
//				case 'f': 
//					gw.fireMissile();
//					break;
//				case 'L': 
//					gw.launchMissile();
//					break;
//				case 'm':
//					gw.printMap();
//					break;
//				case 'p':
//					gw.printDisplay();
//					break;
//				case '>': 
//					//gw.turnMissileLauncher();
//					//gw.ML();
//					gw.turnPSML();
//					break;
//				case 'n':
//					gw.reSupply();
//					break;
//				case 'k':
//					//gw.killAsteroid();
//					gw.playerShipMissileKillAsteroid(); //works
//					break;
//				case 'e':
//					//gw.killNonPlayerShip();
//					//gw.playerShipMissileKillAsteroid(); 
//					gw.removeMissileAndNPS(); //works
//					break;
//				case 'E':
//					//gw.killPlayerShip();
//					gw.removeMissileAndPS(); //works
//					break;
//				case 'c':
//					//gw.asteroidCollide();
//					gw.removeAstAndPS(); //works
//					break;
//				case 'h':
//					//gw.shipcollide();
//					gw.removeNPSAndPS(); //works
//					break;
//				case 'x':
//					gw.removeAsteroids();//works
//					//gw.removeAstAndAst();
//					break;
//				case 'I':
//					//gw.turnLeft();
//					gw.removeAstAndNPS(); //works
//					break;
//				case 'l':
//					gw.turnShipLeft();
//					break;
//				case 'i':
//					gw.speedUpShip();
//					break;
//				case 'r':
//					gw.turnShipRight();
//					break;
//				case 'd':
//					gw.slowUpShip();
//					break;
//				case 't':
//					gw.tick();
//					break;
//				case 'j':
//					gw.jump();
//					break;
//					
//				
//				}
//				}
//			}
//		});
//				
//		
//	}	
//	
//public void quit()
//{
//	Label myLabel2 = new Label("Do you want to quit? y/n:  ");
//	this.addComponent(myLabel2);
//	final TextField myTextField2 = new TextField();
//	this.addComponent(myTextField2);
//	this.show();
//	
//	myTextField2.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent evt) {
//			String sCommand = myTextField2.getText().toString();
//			myTextField2.clear();
//			if(!sCommand.isEmpty() && sCommand.length() == 1) {
//			switch(sCommand.charAt(0)) {
//			case 'y':
//				gw.quit();
//				break;
//			case 'n':
//				System.out.println("Enter command: ");
//				break;
//				
//			
//			}
//			}
//		}
//});
//	
	

		
		
		
		
		
		
	//}
}
