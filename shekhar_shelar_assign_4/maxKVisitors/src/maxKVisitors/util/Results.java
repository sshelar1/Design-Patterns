package maxKVisitors.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{

	private File file;
	private BufferedWriter bufferedWriter;
	private ArrayList<String> trace;
	
	/**
	 * constructor which sets the private data members to the default values
	 * and if there is no file it will create the new file 
	 */
	public Results(String string) {
		// TODO Auto-generated constructor stub
		MyLogger.writeMessage("Results constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		file = new File(string);
		trace = new ArrayList<String>();
		try {
			if (!file.exists()) {
				bufferedWriter = new BufferedWriter(new FileWriter(file));
				bufferedWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void storeNewResult(String string) {
		trace.add(string);
	}
	
	@Override
	public void writeToStdout() {
		// TODO Auto-generated method stub
		for (int i = 0; i < trace.size(); i++) {
			System.out.println(trace.get(i));
		}
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < trace.size(); i++) {
				bufferedWriter.write(trace.get(i) + "\n");
			}
			bufferedWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
