package gamesrc;

import jgame.Context;
import jgame.GObject;
import jgame.ImageCache;
import jgame.controller.MouseLocationController;
import jgame.listener.LocalClickListener;

public class LevelOne extends GObject {

	private PlayAreaOne playAreaOne = new PlayAreaOne();
	private MenuArea menuArea = new MenuArea();
	private InfoArea infoArea = new InfoArea();
    private boolean settingTurret = false;
    private Bank lifeBank = new Bank(100);
    private Bank moneyBank = new Bank(200);
    
	public LevelOne() {
		setSize(1100, 900);
		// Set play area
		playAreaOne.setAnchorTopLeft();
		playAreaOne.setLocation(0, 0);
		add(playAreaOne);
		// Set menu area
		menuArea.setAnchorTopLeft();
		menuArea.setLocation(0, 800);
		add(menuArea);
		// Set info area
		infoArea.setAnchorTopLeft();
		infoArea.setLocation(1000, 0);
		add(infoArea);
		
	}

	//  Turrets  ++++++++++++++++++++++++++++++++++++++++++++++
	
	public void initializeTurret(int tn) {
		//If setting turret--don't allow another turret to be created
		if(settingTurret){
			return;
		}
		settingTurret = true;
		Turret t = getTurret(tn);
		
		t.setScale(.5);

		this.playAreaOne.addAtCenter(t);
		//  Create a new Turret and set radius to turret fire range
		final RangeRing rr = new RangeRing(t.getFireRange());
		this.playAreaOne.addAtCenter(rr);		
		final MouseLocationController c = new MouseLocationController(); 
		t.addController(c); // attach controller to turret t
		rr.addController(c); // attach controller to range ring
		
		// When turret is dropped, 
		final LocalClickListener dropListener = new LocalClickListener(){
			//@Override
			public void invoke(GObject target, Context context){
			  ((Turret) target).setIsSet(true);
			   target.removeController(c);
			   rr.removeController(c);
			   rr.removeSelf();
			   target.removeListener(this);
			   settingTurret = false;
			   
			}
		};
		t.addListener(dropListener);
	}

	public Turret getTurret(int tn) {
		switch (tn + 1) {
		case 1:
			return new TurretOne(ImageCache.getImage("turrets2/t1.png"));
		case 2:
			return new TurretTwo(ImageCache.getImage("turrets2/t2.png"));
		case 3:
			return new TurretThree(ImageCache.getImage("turrets2/t3.png"));
		case 4:
			return new TurretFour(ImageCache.getImage("turrets2/t4.png"));
		case 5:
			return new TurretFive(ImageCache.getImage("turrets2/t5.png"));
		case 6:
			return new TurretSix(ImageCache.getImage("turrets2/t6.png"));
		case 7:
			return new TurretOne(ImageCache.getImage("turrets2/t7.png"));

		default:
			return null;
		}
	}
	
	
	
	
}
