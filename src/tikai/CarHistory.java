package tikai;

import java.util.ArrayList;

public class CarHistory {
	private Enonce e;
	public static int initedCar=0;
	private int id=initedCar++;
	public final ArrayList<Integer> h=new ArrayList<Integer>();
	public int timeElapsed=0;
	public CarHistory(Enonce e) {
		this.e=e;
		h.add(e.indexStart);
		
	}
	public Junction currentJunction() {
		return e.juncList.get(h.get(h.size()-1));
	}
	@Override
	public String toString() {
		return ""+id+h.toString();
	}
	public int currentIndex() {
		return h.get(h.size()-1);
	}
	private double preferredX,preferredY;
	public void setDirection(double cos, double sin) {
		// TODO Auto-generated method stub
		
	}
}
