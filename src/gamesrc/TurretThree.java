package gamesrc;

import java.awt.Image;

import jgame.ImageCache;

public class TurretThree extends Turret {
	private int turretNumber = 1;
	private double fireRange = 300;
	private int fireDelay = 0;
	private int fireCoolDown = 24;
	private double bulletSpeed = 12;
	private int turretValue = 100;
	public TurretThree(Image img) {
		super(img, 3);
	}

	public Bullet createBullet(){
		  return new Bullet(ImageCache.getImage("bullets/b3.png"));
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
}