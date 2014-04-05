package tikai;

import iotools.WriteTool;

import java.io.IOException;
import java.util.ArrayList;

public class OutPut {
	public int nbT;
	public final ArrayList<CarHistory> carsHist=new ArrayList<CarHistory>();
	private Enonce enonce;
	public void moveCar(int indexCar,Street str)
	{
		CarHistory tempch=this.carsHist.get(indexCar);
		if(enonce.juncList.get(tempch.h.get(tempch.h.size()-1))!=str.getA(enonce))
			throw new Error("bad street");
		if(tempch.timeElapsed+str.getTimeCost()<=nbT)
			tempch.h.add(str.getIndexB());
	}
	public OutPut(Enonce e) {
		this.enonce=e;
		this.nbT=e.nbT;
		for(int i=0; i<e.nbCar;++i)
			carsHist.add(new CarHistory(e.indexStart));
	}
	public void outPutToFile(String path)
	{
		WriteTool wr=new WriteTool(path);
		try {
			int numbCars=0;
			wr.w.write(""+(numbCars=carsHist.size())+'\n');
			for(int i = 0; i<numbCars;i++)
			{
				int nbJunctionVisited=0;
				wr.w.write(""+(nbJunctionVisited=carsHist.get(i).h.size())+'\n');
				for(int j = 0; j<nbJunctionVisited;j++)
				{
					wr.w.write(""+carsHist.get(i).h.get(j)+'\n');
				}
			}
			wr.w.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
