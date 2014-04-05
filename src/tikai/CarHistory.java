package tikai;

import java.util.ArrayList;

public class CarHistory {
	public final ArrayList<Integer> h=new ArrayList<Integer>();
	public int timeElapsed=0;
	public CarHistory(int indexSource) {
		h.add(indexSource);
	}
}
