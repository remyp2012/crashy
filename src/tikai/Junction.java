package tikai;

import java.util.ArrayList;
import java.util.Collections;

public class Junction {
	private double x,y;
	public static int tot=0;
	private int id=(tot++);
	@Override
	public String toString() {
		return ""+id;
	}
	public static Junction sortingJunction;
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
	public Street nextBest(int i) {
		if(Street.mode==1)
			return nextBest1();
		else if(Street.mode==2)
			return nextBest2();
		else
			return nextBest2();
	}
	public Street nextBest1() {
		int tempP=pointer;
		pointer=(pointer+1)%outwardStreets.size();
		return outwardStreets.get(outwardStreets.size()-tempP-1);
	}
	public Street nextBest2() {
		sortingJunction=this;
		Collections.sort(outwardStreets);
		return outwardStreets.get(outwardStreets.size()-1);
	}
}
