package tikai;

import iotools.WriteTool;

import java.io.IOException;
import java.util.ArrayList;

public class OutPut {
	public final ArrayList<CarHistory> carsHist=new ArrayList<CarHistory>();
	public void moveCar(int indexCar,int newJunctionIndex)
	{
		this.carsHist.get(indexCar).h.add(newJunctionIndex);
	}
	public OutPut(int nbCar,int indSource) {
		for(int i=0; i<nbCar;++i)
			carsHist.add(new CarHistory(indSource));
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
