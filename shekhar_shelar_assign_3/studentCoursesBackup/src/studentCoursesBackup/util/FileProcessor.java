package studentCoursesBackup.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileProcessor {
	
	private File file;
	private Scanner scanner;
	
	/**
	 * constructor which sets the private data members to the default values
	 */
	
	public FileProcessor(String string) {
		// TODO Auto-generated constructor stub
		file = new File(string);
		MyLogger.writeMessage("Fileprocessor constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		try {
			if (!file.exists()) {
				System.out.println("File " + string + " does not exist");
				System.exit(1);
			}
			scanner = new Scanner(file);
			if (!scanner.hasNextLine()) {
				System.out.println("File " + string + " does not contain any data");
				System.exit(1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * this method reads the elements line by line
	 * @return
	 */
	
	public String readLine() {
		MyLogger.writeMessage("Fileprocessor processing input file", MyLogger.DebugLevel.FILE_PROCESSOR);
		while (scanner.hasNextLine()) {
			return scanner.nextLine();
		}
		return null;
	}
}
