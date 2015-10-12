package gamesrc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.MouseLocationController;
import jgame.listener.FrameListener;
import jgame.listener.LocalClickListener;
import jgame.listener.TimerListener;

public class LevelOne extends GObject {

	private PlayAreaOne playAreaOne = new PlayAreaOne();
	private MenuArea menuArea = new MenuArea();
	private InfoArea infoArea = new InfoArea();
	private boolean settingTurret = false;
	private GSprite sprite;
	private BufferedImage ss;

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

		TimerListener tl = new TimerListener(20) {
			
			public void invoke(GObject target, Context context) {
				BufferedImageLoader loader = new BufferedImageLoader();
				try {
					ss = loader.loadImage("spritesheet.png");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.print(1);
				SpriteSheet spriteSheet = new SpriteSheet(ss);
				BufferedImage buffSprite = spriteSheet.getSprite(0, 0);
				BufferedImage bg = ImageCache.forClass(TowerGame.class).get("spritesheet.png");
				sprite = new GSprite(bg);
				
				System.out.println("In Sprite = " + sprite);
			}
		};
		addListener(tl);
		if (sprite != null) {
			this.playAreaOne.addAtCenter(sprite);
		} else {
			System.out.println("Out Sprite = " + sprite);
		}

	}

	public void initializeTurret(int tn) {
		// If setting turret--don't allow another turret to be created
		if (settingTurret) {
			return;
		}
		settingTurret = true;
		Turret t = getTurret(tn);

		t.setScale(.5);

		this.playAreaOne.addAtCenter(t);

		final RangeRing rr = new RangeRing(t.getFireRange());
		this.playAreaOne.addAtCenter(rr);
		final MouseLocationController c = new MouseLocationController();
		t.addController(c); // attach controller to turret t
		rr.addController(c);

		final LocalClickListener dropListener = new LocalClickListener() {
			// @Override
			public void invoke(GObject target, Context context) {
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
