package tikai;

import iotools.WriteTool;

import java.io.IOException;
import java.util.ArrayList;

public class outPut {
	public final ArrayList<CarHistory> carsHist=new ArrayList<CarHistory>();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
