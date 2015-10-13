package gamesrc;

import java.awt.Image;
import java.awt.Polygon;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;

public abstract class Enemy extends GSprite {

	private double maxHealth;
	private double currentHealth;
	private int moneyValue;
	private HealthBar hb = new HealthBar();
	
	public Enemy(List<Image> images, double maxHlth, int moneyValue ) {
		super(images);
		this.maxHealth = maxHlth;
		this.currentHealth = maxHealth;
		this.moneyValue = moneyValue;
		
		
		hb.setWidth(getWidth());
		addAtCenter(hb);
		hb.setY(this.getHeight() - hb.getHeight() / 2);
		hb.setHealthPercentage(1);

	
		int[] x = new int[] { 1, 26, 51, 77, 102, 127, 152, 177, 202, 227, 251, 277, 
				302, 327, 353, 378, 404, 430, 456, 481, 507, 532, 557, 582, 606, 628, 
				647, 661, 673, 680, 681, 679, 673, 664, 651, 632, 612, 590, 565, 540, 
				515, 490, 464, 438, 412, 387, 362, 337, 312, 289, 267, 247, 229, 219, 
				220, 230, 244, 258, 275, 293, 313, 333, 354, 376, 399, 424, 449, 474, 
				500, 527, 553, 579, 605, 631, 656, 682, 707, 732, 758, 784, 809, 835, 
				860, 885, 911, 936, 962, 987, 1013, 1050 };
		int[] y = new int[] { 150, 152, 149, 145, 138, 131, 122, 113, 104, 94, 85, 77, 
				70, 64, 58, 53, 49, 46, 45, 44, 43, 48, 53, 59, 67, 79, 97, 119, 141, 
				166, 191, 216, 241, 265, 287, 305, 321, 333, 341, 346, 350, 353, 356, 
				358, 362, 367, 374, 382, 390, 401, 414, 430, 449, 472, 498, 522, 544, 
				565, 584, 602, 619, 635, 649, 662, 673, 681, 686, 692, 695, 695, 695, 
				695, 693, 689, 684, 679, 673, 668, 663, 658, 655, 652, 649, 646, 642, 
				639, 637, 634, 634, 700 };
		Polygon p = new Polygon(x, y, 90);
		PolygonController pc = new PolygonController(p);

		pc.goToStart(this);
		pc.setRotateToFollow(true);
		addController(pc);
		this.setAnchorCenter();
	}

	public abstract double getSlowness();
	public abstract int getCurrentHealth();
	public abstract void setCurrentHealth(int i);
	public abstract void setStartHealth(int startHealth);
	// public abstract int getReward();
	// public abstract boolean slowVulnerable();
	// public abstract boolean turretDestroy();

}