package gamesrc;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;
import java.lang.Cloneable.*;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.TimerListener;

public class PlayAreaOne<Vector2f> extends GContainer {

	public PlayAreaOne() {
		setSize(1000, 800);
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("bg2b.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);

//		List<Image> turretOneImages = ImageCache.forClass(TowerGame.class).getSequential(
//       			"turrets2/t1/t1", 0, 9, ".png");
		
		final TimerListener EnemyTimer = new TimerListener(64) {
			public void invoke(GObject target, Context context) {
				initEnemy();
			}
		};
		addListener(EnemyTimer);
	}

	public void initEnemy() {
		List<Image> enemyImages = ImageCache.forClass(TowerGame.class).getSequential(				           											"enemies/terry/t", 0, 9, ".png");
		Enemy e = new Enemy(enemyImages);
		e.setScale(.95);		
		this.add(e);
	}
	
	
}
