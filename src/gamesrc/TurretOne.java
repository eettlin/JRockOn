package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.ImageCache;

public class TurretOne extends Turret {
	private int turretNumber = 1;
	private double fireRange = 100;
	private int fireDelay = 0;
	private int fireCoolDown = 24;
	private double bulletSpeed = 12;
	private int turretValue = 100;
	private Point startPosition = null;
	
	public TurretOne(Image img) {
		super(img, 1);

	}
	
	public Bullet createBullet(){
		  // We don't need to receive a point here.  Instead, just get turret pos
		  Bullet b = new BulletOne(ImageCache.getImage("bullets/b1.png"), new Point(this.getPosition()));
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
       System.out.println("In turret one setStartPos " + startPosition);
       
	}
	
	@Override
	public Point getStartPosition() {
       return startPosition;		
	}


}
