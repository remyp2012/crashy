package tikai;

public class TikaiRun {

	public static void main(String[] args) {
		Enonce enonce= new Enonce("/home/teacup123123/Desktop/paris_54000.txt");
		OutPut out=new OutPut(enonce.nbCar,enonce.indexStart);
//		lots of out.moveCar(indexCar, newJunctionIndex);...
		out.outPutToFile("/home/teacup123123/Desktop/result.txt");
	}

}
