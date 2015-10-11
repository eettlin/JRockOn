package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.ImageCache;

public class TurretThree extends Turret {
	private int turretNumber = 1;
	private double fireRange = 300;
	private int fireDelay = 0;
	private int fireCoolDown = 24;
	private double bulletSpeed = 12;
	private int turretValue = 100;
	private Point startPosition = null;
	
	public TurretThree(Image img) {
		super(img, 3);
	}

	public Bullet createBullet(){
		  return new BulletOne(ImageCache.getImage("bullets/b3.png"), new Point(this.getPosition()));
	}


	@Override
	public double getBulletSpeed() {
		return bulletSpeed;
	}

	@Override
	public int getTurretNumber() {
		return turretNumber;
	}

	@Override
	public double getFireRange() {
		return fireRange;
	}

	@Override
	public int getFireDelay() {
		return fireDelay;
	}

	@Override
	public int getFireCoolDown() {
		return fireCoolDown;
	}

	@Override
	public int getTurretValue() {
		return turretValue;
	}
	@Override
	public void setStartPosition(Point p) {
       startPosition = p;		
	}
	
	public Point getStartPosition() {
       return startPosition;		
	}
}