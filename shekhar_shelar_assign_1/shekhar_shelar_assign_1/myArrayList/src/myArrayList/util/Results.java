package myArrayList.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{

	private File file;
	private StringBuilder outputString;
	private BufferedWriter bufferedWriter;
	
	public Results(String string) {
		// TODO Auto-generated constructor stub
		outputString = new StringBuilder();
		file = new File(string);
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
	
	public StringBuilder getOutputString() {
		return outputString;
	}

	public void setOutputString(StringBuilder outputString) {
		this.outputString = outputString;
	}

	public void storeNewResult(String string) {
		outputString.append(string + "\n");
	}
	
	@Override
	public void writeToStdout(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

	@Override
	public void writeToFile(String s) {
		// TODO Auto-generated method stub
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(s + "\n");
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("writeToFile : " + e.getMessage());
		}
	}

}
