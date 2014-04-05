package iotools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTool {
	public BufferedReader r = null;
	private String lastLine;
	private String splitted[];
	private int pointer;
	
	public String segment(int i)
	{
		return splitted[i];
	}
	
	public String readLine()
	{
		try {
			lastLine=r.readLine();
			splitted=lastLine.split(" ");
			pointer=splitted.length;
			return lastLine;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String readWord()
	{
		++pointer;
		return splitted[pointer-1];
	}
	public ReadTool(String s) {
		try {
			r = new BufferedReader(new FileReader(s));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			r=null;
		}
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if(r!=null)
			r.close();
	}
	
}
