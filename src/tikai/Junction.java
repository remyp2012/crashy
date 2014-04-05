package tikai;

import java.util.ArrayList;

public class Junction {
	private double x,y;

	public final ArrayList<Street> outwardStreets=new ArrayList<Street>();

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Junction(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
}
