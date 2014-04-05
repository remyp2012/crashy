package tikai;

import iotools.ReadTool;

import java.util.ArrayList;
import java.util.Collections;

public class Enonce {
	public final int nbJunc, nbStr,nbT,nbCar,indexStart;
	public final ArrayList<Junction> juncList=new ArrayList<Junction>();
	public final ArrayList<Street> streetList=new ArrayList<Street>();
	public Enonce(String str) {
		ReadTool read=new ReadTool(str);
		read.readLine();
		nbJunc=Integer.parseInt(read.segment(0));
		nbStr=Integer.parseInt(read.segment(1));
		nbT=Integer.parseInt(read.segment(2));
		nbCar=Integer.parseInt(read.segment(3));
		indexStart=Integer.parseInt(read.segment(4));


		for(int i=0;i<nbJunc;++i)
		{
			read.readLine();
			juncList.add(
					new Junction(Double.parseDouble(read.segment(0)),Double.parseDouble(read.segment(1)))
					);
		}
		for(int i=0;i<nbStr;++i)
		{
			read.readLine();
			Street tempStr;
			streetList.add(tempStr=
					new Street(Integer.parseInt(read.segment(0)),
							Integer.parseInt(read.segment(1)),
							(Integer.parseInt(read.segment(2))==2),
							Integer.parseInt(read.segment(3)),
							Integer.parseInt(read.segment(4)),this
							)
					);
			
			tempStr.getA(this).outwardStreets.add(tempStr);
			if(tempStr.isBiDirection())tempStr.getB(this).outwardStreets.add(tempStr);
		}
		for(int i=0;i<nbJunc;++i)
		{
			Collections.sort(juncList.get(i).outwardStreets);
		}

	}
}
