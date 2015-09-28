package gamesrc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import jgame.GObject;

public class RangeRing extends GObject {
	private double radius = 0;

	public RangeRing(double radius) {
		setSize(radius*2, radius*2);
		this.radius = radius;
	}

	
	public void paint(Graphics2D g) {
		super.paint(g);
		// g is a graphics context
		// build a white circle with 50% opacity
		g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		//  draw (outline) it we would set the stroke as follows:
		BasicStroke bs = new BasicStroke(2);
		g.setStroke(bs);
		g.drawOval(getIntWidth()/4, getIntHeight()/4, getIntWidth()/2, getIntHeight()/2);	
		// fill it in:
		g.fillOval(getIntWidth()/4, getIntHeight()/4, getIntWidth()/2, getIntHeight()/2);
	}
	
	@Override
	public void preparePaint(Graphics2D g) {
		super.preparePaint(g);
		antialias(g);
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double r) {
		radius = r;
	}
}
