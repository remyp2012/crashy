package tikai;

public class Street implements Comparable<Street>{
	private int indexA,indexB;
	private Junction A,B;
	private boolean biDirection;
	private int timeCost;
	private int length;

	@Override
	public String toString() {
		return ""+indexA+((biDirection)?"<":"")+"->"+indexB+":t="+timeCost+",l="+length;
	}
	public Street(int indexA, int indexB, boolean biDirection, int timeCost,
			int length,Enonce e) {
		super();
		this.indexA = indexA;
		this.indexB = indexB;
		A=e.juncList.get(indexA);
		B=e.juncList.get(indexB);
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

	@Override
	public int compareTo(Street o) {
		int myspeed,his;
		if((myspeed=length*1000/timeCost)>(his=o.length*1000/o.timeCost))
			return 1;
		else if(myspeed==his)
			return 0;
		else return -1;
	}

	public Junction getA(Enonce e) {
		return e.juncList.get(indexA);
	}
	public Junction getB(Enonce e) {
		return e.juncList.get(indexB);
	}
	public boolean goAble(Junction junction) {
		boolean result;
		if(biDirection)
			result=junction == A ||junction==B;
		else
			result=junction == A;
		if(!result)
			throw new Error("bad street");
		return result;
	}
}
