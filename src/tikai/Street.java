package tikai;

public class Street {
	private int indexA,indexB;
	private boolean biDirection;
	private int timeCost;
	private int length;
	
	public Street(int indexA, int indexB, boolean biDirection, int timeCost,
			int length) {
		super();
		this.indexA = indexA;
		this.indexB = indexB;
		this.biDirection = biDirection;
		this.timeCost = timeCost;
		this.length = length;
	}
	
	public int getIndexA() {
		return indexA;
	}
	public void setIndexA(int indexA) {
		this.indexA = indexA;
	}
	public int getIndexB() {
		return indexB;
	}
	public void setIndexB(int indexB) {
		this.indexB = indexB;
	}
	public boolean isBiDirection() {
		return biDirection;
	}
	public void setBiDirection(boolean biDirection) {
		this.biDirection = biDirection;
	}
	public int getTimeCost() {
		return timeCost;
	}
	public void setTimeCost(int timeCost) {
		this.timeCost = timeCost;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
