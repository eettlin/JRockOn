package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.ImageCache;

public class TurretSix extends Turret {
	
	private int turretNumber = 6;
	private double fireRange = 500;
	private int fireDelay = 0;
	private int fireCoolDown = 24;
	private double bulletSpeed = 33;
	private int turretValue = 100;
	private Point startPosition = null;
	
	public TurretSix(Image image) {
		super(image, 6);
	}

	@Override
	public Bullet createBullet(){
		  return new BulletFive(ImageCache.getImage("bullets/b6.png"),  new Point(this.getPosition()));
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
