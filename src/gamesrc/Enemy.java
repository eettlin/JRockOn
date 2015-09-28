package gamesrc;
import java.awt.Image;
import java.awt.Polygon;
import java.util.List;

import jgame.GSprite;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;

public class Enemy extends GSprite {

	public double currentBytes;
	int ScrewYouStefan = 0;

	public Enemy(List<Image> images) {
		super(images);
		addListener(new BoundaryRemovalListener());
		
		
		int[] x = new int[] { 0,100,125,150,175,200,225,250,
				              275,300,325,350,375,400,425,450,475,500,
				              525,550,575,600,625,650,675,700,725,750,
				              775,800,825,850,875,900, 1100, 1200};
		int[] y = new int[] { 0,100,125,150,175,200,225,250,
				              275,300,325,350,375,400,425,450,475,500,
				              525,550,575,600,625,650,675,700,725,750,
				              775,800,825,850,875,900, 1100 , 1200};
		Polygon p = new Polygon(x, y, 35);
		final PolygonController pc = new PolygonController(p);

		pc.goToStart(this);
		pc.setRotateToFollow(true);
		addController(pc);
		this.setAnchorCenter();
		
	}
	


// public abstract double getSlowness();

// public abstract double getMaxBytes();

// public abstract int getReward();

// public abstract boolean slowVulnerable();

// public abstract boolean turretDestroy();

}