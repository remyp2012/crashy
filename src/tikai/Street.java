package tikai;

public class Street implements Comparable<Street>{
	public static double rapportTrajCurrentCar = 0;
	public boolean fromA = true;
	public static int currentDirection = 0;
	public static int mode = 0;
	private int indexA,indexB;
	private Junction A,B;
	private boolean biDirection;
	private int timeCost;
	private int length;
	private int timesVisited=0;
	public void addVisited()
	{
		timesVisited++;
	}
	private int streetScore1()
	{
		return length*1000/timeCost;
	}
	private int streetScore2()
	{
		return timesVisited*-3000+length*10/timeCost;
	}
	public static double attraction(double t, int car){
		double att=0;
		if(t<0.1)
			att=10;
		else att=1/t;
		if(car==3||car==4||car==5)
			return att/10*100;
		return att/10;
	}
	public double attraction2(double t, int car){
		double att=0;
		if(t<0.05)
			att=50;
		else att=1/t;
		return att/50;
	}
	private double streetScore3(int direction,boolean AtoB,double rapportTrajet)//rapport between 0 and 1
	{
		double cos=Math.cos(direction*2*Math.PI/8);
		double sin=Math.sin(direction*2*Math.PI/8);
		double cosStr=0,sinStr=0;

		cosStr=B.getX()-A.getX();
		sinStr=B.getY()-A.getY();
		double norm=norme(cosStr, sinStr);
		cosStr/=norm;
		sinStr/=norm;
		return timesVisited*-900+length*10/timeCost+((AtoB)?1:-1)*dot(cosStr, sinStr, cos, sin)*attraction2(rapportTrajet,direction)*300;
	}
	public static double dot(double x, double y, double x1, double y1)
	{
		return x*x1+y*y1;
	}
	public static double norme(double x, double y)
	{
		return Math.sqrt(x*x+y*y);
	}

	@Override
	public String toString() {
		return ""+indexA+((biDirection)?"<":"")+"->"+indexB+":v="+length/timeCost+",.="+timesVisited;
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
		double myspeed,his;
		if((myspeed=streetScore())>(his=o.streetScore()))
			return 1;
		else if(myspeed==his)
			return 0;
		else return -1;
	}

	private double streetScore() {
		if(mode==1)
			return streetScore1();
		else if(mode==2)
			return streetScore2();
		else
		{
			fromA=Junction.sortingJunction==A;
			return streetScore3(currentDirection, Junction.sortingJunction==A, rapportTrajCurrentCar);
		}
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
