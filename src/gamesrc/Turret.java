package gamesrc;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantMovementController;
import jgame.controller.ConstantRotationController;
import jgame.listener.DelayListener;
import jgame.listener.FrameListener;

public abstract class Turret extends GSprite {
	private int coolDown = 10;
    private int turretNumber = 0;
	public Turret(Image img, int tn) {
		super(img);
		super.setAnchorCenter();
        turretNumber = tn;
		this.addListener(new FrameListener() {
			public void invoke(GObject target, Context context) {
				//Create a list of all enemies currently in the play area (context)
				List<Enemy> enemies = context.getInstancesOfClass(Enemy.class);
				double closestDistance = Double.MAX_VALUE;
				int currentClosest = 0;
				//Look through all enemies and find closest
				for (int i = enemies.size() - 1; i >= 0; i--) {
					if (target.distanceTo(enemies.get(i)) < closestDistance) {
						closestDistance = target.distanceTo(enemies.get(i));
						currentClosest = i;
						//face the closest enemy
						target.face(enemies.get(currentClosest));
					}
				}

				if (coolDown-- < 0) {
					fireBullet();
					coolDown = 24;
				}
			}
		});
	}

	
    public abstract int getTurretNumber();
	public abstract double getFireRange();
	public abstract int getFireDelay();
	public abstract int getFireCoolDown();
	public abstract int getTurretValue();
	public abstract double getBulletSpeed();
	public abstract Bullet createBullet();
	
	public void fireBullet() {
		// create an instance of BulletOne
		final Bullet b = createBullet();
		switch(turretNumber){
		case 1:
			b.setScale(1);
			break;
		case 2:
			b.setScale(.3);
	        ConstantRotationController clc = new ConstantRotationController(42);
	        b.addController(clc);
			break;
		case 3:
			b.setScale(.5);
			break;
		case 4:
			b.setScale(1);
			break;
		case 5:
			b.setScale(1);
			break;
		case 6:
			b.setScale(.51);
			break;
		case 7:
			b.setScale(1);
			break;
		}
		b.setRotation(this.getRotation());
		final ConstantMovementController c = ConstantMovementController
				.createPolar(getBulletSpeed(), getRotation());
		DelayListener dl = new DelayListener(0) {
			public void invoke(GObject target, Context context) {
				// after specified frames start moving
				// c.setDamping(1.1);
				b.addController(c);
			}
		};
		b.addListener(dl);
		// move the bullets at a particular speed
		this.snapAnchor(b);
		b.moveAtAngle(getHeight() / 2 + 10, getRotation());

		this.addSibling(b);
	}

}
