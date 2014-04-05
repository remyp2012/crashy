package tikai;

import iotools.ReadTool;

public class Enonce {
	public final int nbJunc, nbStr,nbT,nbCar,indexStart;
	public Enonce(String str) {
		ReadTool read=new ReadTool(str);
		read.readLine();
		nbJunc=Integer.parseInt(read.segment(0));
		nbStr=Integer.parseInt(read.segment(1));
		nbT=Integer.parseInt(read.segment(2));
		nbCar=Integer.parseInt(read.segment(3));
		indexStart=Integer.parseInt(read.segment(4));
		
		
	}
}
