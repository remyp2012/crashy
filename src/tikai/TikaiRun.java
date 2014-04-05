package tikai;

public class TikaiRun {

	public static void main(String[] args) {
		Enonce enonce= new Enonce("/home/teacup123123/Desktop/paris_54000.txt");
		Junction j=enonce.juncList.get(2);
		System.out.println(j.getX());
		System.out.println(j.getY());
		Street str=enonce.streetList.get(2);
		System.out.println(str.getIndexA());
		System.out.println(str.getLength());
	}

}
