package tikai;

import java.util.ArrayList;

public class CarHistory {
	public static int initedCar=0;
	private int id=initedCar++;
	public final ArrayList<Integer> h=new ArrayList<Integer>();
	public int timeElapsed=0;
	public CarHistory(int indexSource) {
		h.add(indexSource);
	}
	public Junction currentJunction(Enonce e) {
		return e.juncList.get(h.get(h.size()-1));
	}
	@Override
	public String toString() {
		return ""+id+h.toString();
	}
	public int currentIndex() {
		return h.get(h.size()-1);
	}
}
