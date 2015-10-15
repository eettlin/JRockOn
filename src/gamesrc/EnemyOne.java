package gamesrc;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.listener.FrameListener;

public class EnemyOne extends Enemy {
	@SuppressWarnings("unused")
	private int startHealth;
	private int currentHealth;

	public EnemyOne(List<Image> images, int startHealth) {
		super(images, startHealth, 100);
		this.setStartHealth(startHealth);
		currentHealth = startHealth;
		FrameListener fl = new FrameListener() {
			public void invoke(GObject target, Context context) {
				//if(getCurrentHealth() < 0) removeSelf();
			}
		};
		addListener(fl);
	}

	public double getSlowness() {
		return 0;
	}

	public double getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setStartHealth(int startHealth) {
		this.startHealth = startHealth;
	}

	@Override
	public double getMaxHealth() {
		return startHealth;
	}

}
