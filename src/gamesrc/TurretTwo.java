package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.ImageCache;

public class TurretTwo extends Turret {
	private int turretNumber = 2;
	private double fireRange = 400;
	private int fireDelay = 0;
	private int fireCoolDown = 24;
	private double bulletSpeed = 12;
	private int turretValue = 100;
	private Point startPosition = null;

	public TurretTwo(Image img) {
		super(img, 2);
	}

	public Bullet createBullet(){
		  Bullet b = new BulletOne(ImageCache.getImage("bullets/b2.png"),  new Point(this.getPosition()));
		  b.setStartPosition(this.getPosition());
		  return  b;
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
