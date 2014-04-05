package iotools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTool {
	public BufferedWriter w=null;
	public WriteTool(String path) {
		File file1 = new File(path);
		try{
			// if file doesn't exists, then create it
			if (!file1.exists()) {
				file1.createNewFile();
				System.out.println("file created");
			}
			FileWriter fw = new FileWriter(file1.getAbsoluteFile());
			w = new BufferedWriter(fw);
		}catch(IOException e)
		{
			e.printStackTrace();
			w=null;
		}
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if(w!=null)
			w.close();
	}
}
