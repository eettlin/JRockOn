package gamesrc;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;
import jgame.listener.HitTestListener;

public abstract class Bullet extends GSprite {

	public Bullet(Image image) {
		super(image);
		addListener(new BoundaryRemovalListener());

		FrameListener fl = new FrameListener() {
			public void invoke(GObject target, Context context) {
				// List<Enemy> enemies =
			}
		};
		addListener(fl);

		HitTestListener htl = new HitTestListener(Enemy.class) {
			// target is the bullet and context is the crystal ball
			public void invoke(GObject target, Context context) {
				// import java.util.list (not java.awt)
				List<Enemy> enemies = context.hitTestClass(Enemy.class);
				// SoundManager.forClass(TowerGame.class).play("bink.wav");
				for (Enemy enemy : enemies) {
					// enemy.setCurrentHealth(enemy.getCurrentHealth()-bd);
					enemy.removeSelf();
				}
				target.removeSelf();// remove the bullet if hit enemy
			}
		};
		addListener(htl);
	}

	// abstract methods
	public abstract void setStartPosition(Point p);

	public abstract Point getCurrentPosition();// we don't need this

	public double getDistanceFromStart(Point p1, Point p2) {
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();

		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
}
