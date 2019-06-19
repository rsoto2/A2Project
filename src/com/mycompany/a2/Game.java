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
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.*;
import com.codename1.charts.util.ColorUtil;

import java.lang.String;
import java.util.Observer;


public class Game extends Form {
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	private GameButton npsbutton, newbutton, quitbutton, asteroid, ssbutton, shipbutton, ispeedbutton, dsbutton, leftbutton, rightbutton, missilebutton, hyperbutton, refuelbutton;
	
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
	
	
	private Container leftButtons;
	
	
	
	
	
	public Game()  {
		gw = new GameWorld();
		mv = new MapView();
		pv = new PointsView();
		gw.addObserver(mv);
		gw.addObserver(pv);
		this.show();
		//this.setTitle("Asteroid");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, mv);
		
		this.add(BorderLayout.NORTH, pv);
		
		
		leftButtons = new Container();
		leftButtons.getAllStyles().setBgTransparency(0);
		leftButtons.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		leftButtons.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		//leftButtons.getAllStyles().setBackgroundGradientStartColor(ColorUtil.BLACK);
		leftButtons.getAllStyles().setBgColor(ColorUtil.GREEN);
		//leftButtons.setFocus(false);
		
		

		this.add(BorderLayout.WEST, leftButtons);
		


		asteroid = new GameButton("Asteroid");
		asteroid.getAllStyles().setBgTransparency(255);
		asteroid.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		asteroid.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addastro = new AddAsteroidCommand(gw);
		asteroid.setCommand(addastro);
		this.addKeyListener('a', addastro);
		leftButtons.addComponent(asteroid);
		asteroid.setFocusable(false);
		
		npsbutton = new GameButton("NPS");
		npsbutton.getAllStyles().setBgTransparency(255);
		npsbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		npsbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		nps = new AddNPSCommand(gw);
		npsbutton.setCommand(nps);
		this.addKeyListener('y', nps);
		leftButtons.addComponent(npsbutton);
		npsbutton.setFocusable(false);
		
		ssbutton = new GameButton("Station");
		ssbutton.getAllStyles().setBgTransparency(255);
		ssbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		ssbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addstation = new AddStationCommand(gw);
		ssbutton.setCommand(addstation);
		this.addKeyListener('b', addstation);
		leftButtons.addComponent(ssbutton);
		ssbutton.setFocusable(false);
		
		shipbutton= new GameButton("Ship");
		shipbutton.getAllStyles().setBgTransparency(255);
		shipbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		shipbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addShip = new AddShipCommand(gw);
		shipbutton.setCommand(addShip);
		this.addKeyListener('s', addShip);
		leftButtons.addComponent(shipbutton);
		shipbutton.setFocusable(false);
		
//		ispeedbutton = new GameButton("Increase Speed");
//		ispeedbutton.getAllStyles().setBgTransparency(255);
//		ispeedbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
//		ispeedbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		iSpeed = new IncreaseSpeedCommand(gw);
//		ispeedbutton.setCommand(iSpeed);
		this.addKeyListener(-91, iSpeed);
//		leftButtons.addComponent(ispeedbutton);
//		ispeedbutton.setFocusable(false);
		
//		dsbutton = new GameButton("Decrease Speed");
//		dsbutton.getAllStyles().setBgTransparency(255);
//		dsbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
//		dsbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		dSpeed= new DecreaseSpeedCommand(gw);
//		dsbutton.setCommand(dSpeed);
		this.addKeyListener(-92, dSpeed);
//		leftButtons.addComponent(dsbutton);
//		dsbutton.setFocusable(false);
		
//		leftbutton = new GameButton("TurnLeft");
//		leftbutton.getAllStyles().setBgTransparency(255);
//		leftbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
//		leftbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		tl = new TurnLeftCommand(gw);
		//leftbutton.setCommand(tl);
		this.addKeyListener(-93, tl);
		//addKeyListener(-93, tl);
		//leftButtons.addComponent(leftbutton);
		//leftbutton.setFocusable(false);
		
//		rightbutton = new GameButton("Turn Right");
//		rightbutton.getAllStyles().setBgTransparency(255);
//		rightbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
//		rightbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		rl= new TurnRightCommand(gw);
	//	rightbutton.setCommand(rl);
		this.addKeyListener(-94, rl);
//		leftButtons.addComponent(rightbutton);
//		rightbutton.setFocusable(false);

		
		missilebutton = new GameButton("Fire Missile");
		missilebutton.getAllStyles().setBgTransparency(255);
		missilebutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		missilebutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		m = new FireMissileCommand(gw);
		missilebutton.setCommand(m);
		this.addKeyListener(-90, m);
		leftButtons.addComponent(missilebutton);
		missilebutton.setFocusable(false);
		
		hyperbutton = new GameButton("HyperSpace");
		hyperbutton.getAllStyles().setBgTransparency(255);
		hyperbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
		hyperbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		h = new HyperSpaceCommand(gw);
		hyperbutton.setCommand(h);
		this.addKeyListener('f', h);
		leftButtons.addComponent(hyperbutton);
		hyperbutton.setFocusable(false);
		
//		refuelbutton = new GameButton("ReSupply");
//		refuelbutton.getAllStyles().setBgTransparency(255);
//		refuelbutton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 150, 150));
//		refuelbutton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		r = new ResupplyCommand(gw);
//		refuelbutton.setCommand(r);
		this.addKeyListener('n', r);
//		leftButtons.addComponent(refuelbutton);
//		refuelbutton.setFocusable(false);
		
//		ssbutton = new GameButton("Pause");
//		addstation = new AddStationCommand(gw);
//		ssbutton.setCommand(addstation);
//		this.addKeyListener('b', addstation);
//		leftButtons.addComponent(ssbutton);
//		ssbutton.setFocusable(false);
//		
//		shipbutton= new GameButton("Exit");
//		addShip = new AddShipCommand(gw);
//		shipbutton.setCommand(addShip);
//		this.addKeyListener('s', addShip);
//		leftButtons.addComponent(shipbutton);
//		shipbutton.setFocusable(false);
		
		
		
		
		this.show();
		gw.init();
		//play();
		
		
		//cContainer = new Container();
		
		//toolbar menu
		Toolbar sideMenu = new Toolbar();
		quitbutton = new GameButton("Quit");
		sideMenu.setUIID("ToolBar");
		sideMenu.getAllStyles().setBgTransparency(0);
		sideMenu.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.rgb(100, 0, 0)));
		sideMenu.getAllStyles().setBackgroundGradientStartColor(ColorUtil.GRAY);
		this.setToolbar(sideMenu);
		sideMenu.setTitle("Asteroid Game");
		sideMenu.getTitleComponent().getAllStyles().setFgColor(ColorUtil.MAGENTA);
		sideMenu.addCommandToOverflowMenu(m);
		
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
		
//		gw.init();
//		play();
//		quit();
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
