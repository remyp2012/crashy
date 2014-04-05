package tikai;

import java.util.ArrayList;

public class Junction {
	private double x,y;
	public static int tot=0;
	private int id=(tot++);
	@Override
	public String toString() {
		return ""+id;
	}

	public final ArrayList<Street> outwardStreets=new ArrayList<Street>();
	int pointer=0;

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

	public Street nextBest() {
		int tempP=pointer;
		pointer=(pointer+1)%outwardStreets.size();
		return outwardStreets.get(tempP);
	}
}
