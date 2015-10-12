package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.ImageCache;

public class TurretFive extends Turret {
	private int turretNumber = 5;
	private double fireRange = 800;
	private int fireDelay = 0;
	private int fireCoolDown = 12;
	private double bulletSpeed = 12;
	private int turretValue = 100;
	private Point startPosition = null;

	public TurretFive(Image img) {
		super(img, 5);
	}
	public Bullet createBullet(){
		  Bullet b = new BulletOne(ImageCache.getImage("bullets/b5.png"),  new Point(this.getPosition()));
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
