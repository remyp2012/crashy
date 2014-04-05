package tikai;

import iotools.WriteTool;

import java.io.IOException;
import java.util.ArrayList;

public class OutPut {
	public int nbT;
	public final ArrayList<CarHistory> carsHist=new ArrayList<CarHistory>();
	private Enonce enonce;
	public int moveCar(int indexCar,Street str)
	{
		CarHistory car=this.carsHist.get(indexCar);
		str.fromA=car.currentIndex()==str.getIndexA();
		
		if(!str.goAble(enonce.juncList.get(car.currentIndex())))//street.goAble(car.currentJunction)
		{
			Junction deb=enonce.juncList.get(car.currentIndex());
			throw new Error("bad street");
		}
		if(car.timeElapsed+str.getTimeCost()<=nbT)
		{
			car.timeElapsed+=str.getTimeCost();
			if(str.fromA)
				car.h.add(str.getIndexB());
			else
				car.h.add(str.getIndexA());
			str.addVisited();
			return 0;}
		else return 1;
	}
	public OutPut(Enonce e) {
		this.enonce=e;
		this.nbT=e.nbT;
		for(int i=0; i<e.nbCar;++i)
		{
			CarHistory temp=new CarHistory(e);
			carsHist.add(temp);
			temp.setDirection(Math.cos(2*Math.PI*i/e.nbCar),Math.sin(2*Math.PI*i/e.nbCar));
		}
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
	public void algoTikai() {
		Street.mode=3;
		int timeUp=0;
		while(timeUp<carsHist.size())
		{
			for(int i=0;i<carsHist.size();++i)
			{
				Street.currentDirection=i;
				Street.rapportTrajCurrentCar=carsHist.get(i).timeElapsed/nbT; 
				timeUp+=moveCar(i, carsHist.get(i).currentJunction().nextBest(i));
			}

		}
	}
}
