package tikai;

public class TikaiRun {

	public static void main(String[] args) {
		Enonce enonce= new Enonce("/Users/peter/Desktop/streetview/paris_54000.txt");
		OutPut out=new OutPut(enonce);
//		lots of out.moveCar(indexCar, newJunctionIndex);...
		out.algoTikai();
		out.outPutToFile("/Users/peter/Desktop/streetview/result.txt");
	}

}
