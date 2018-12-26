package studentCoursesBackup.driver;

import studentCoursesBackup.util.BST;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver{

	
	public static void main(String[] args) {
		FileProcessor fileProcessorInputFile = null, fileProcessorDeleteFile=null;
		Results results = null, resultBackUp1= null, resultBackUp2=null;
		BST bst=null, bstBackUp1=null, bstBackUp2=null;
		TreeBuilder treeBuilder = null;
		int debugLevel=-1;
		String line = null;
		/**
		 * Checking for valid arguments i.e 3
		 */
		if (args.length != 6) {
			System.out.println("Invaid number of arguments");
			System.exit(1);
		}
		
		/**
		 * Checking for valid debug level
		 */
		try {
			debugLevel = Integer.parseInt(args[5]);
			MyLogger.setDebugValue(debugLevel);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid debug level");
			System.exit(1);
		}
		
		/**
		 * Checks if the debug level is in range or not
		 */
		if (debugLevel < 0 || debugLevel > 4) {
			System.out.println("Debug value out of range");
			System.exit(1);
		}
		
		/**
		 * Checking for empty input file
		 */
		
		fileProcessorInputFile = new FileProcessor(args[0]);
		
		/**
		 * Creating results
		 */
		results = new Results(args[2]);
		resultBackUp1 = new Results(args[3]);
		resultBackUp2 = new Results(args[4]);
		
		/**
		 * Creating backup binary trees and passing it to BST
		 */
		bst = new BST(results);
		bstBackUp1 = new BST(resultBackUp1);
		bstBackUp2 = new BST(resultBackUp2);
		
		treeBuilder = new TreeBuilder(bst, bstBackUp1, bstBackUp2);
		String[] record;
		int B_number=-1;
		Character course=null;
		while ((line = fileProcessorInputFile.readLine())!=null) {
			record = line.split(":");
			try {
				B_number = Integer.parseInt(record[0]);
				course = record[1].charAt(0);
				treeBuilder.insert(B_number, course);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid B_number");
			}
		}
		
		fileProcessorDeleteFile = new FileProcessor(args[1]);
		
		while ((line = fileProcessorDeleteFile.readLine())!=null) {
			record = line.split(":");
			try {
				B_number = Integer.parseInt(record[0]);
				course = record[1].charAt(0);
				treeBuilder.delete(B_number, course);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid B_number");
			}
		}
		
		bst.printNode(results);
		bstBackUp1.printNode(resultBackUp1, bstBackUp1.getRoot());
		bstBackUp2.printNode(resultBackUp2, bstBackUp2.getRoot());
		
		results.writeToFile();
		resultBackUp1.writeToFile();
		resultBackUp2.writeToFile();
		
	}
	
}