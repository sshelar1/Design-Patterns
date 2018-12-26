package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;


/**
 * This class implements a simple array functions	
 */

public class Driver{

	/**
	 * this is primary class where which implements all functionalities given in MyArrayList class
	 * @param args
	 */
	public static void main(String[] args) {
		MyArrayList arrayList = new MyArrayList();
		FileProcessor fileProcessor = null;
		Results results = null;
		MyArrayListTest arrayListTest = null;
		String newValue=null;
		
		//It checks for the number of arguments i.e input file and output file
		if (args.length!=2) {
			System.out.println("Invaid number of arguments");
			System.exit(1);
		}
		fileProcessor = new FileProcessor(args[0]);
		results = new Results(args[1]);
		while ((newValue =  fileProcessor.readLine())!=null) {
			try {
				arrayList.insertSorted(Integer.parseInt(newValue));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				results.storeNewResult("NumberFormat Exception occured : " + e.getMessage());
			}
		}
		
		String resultString = "The sum of all the values in the array list is: " + arrayList.sum();
		results.writeToFile(resultString);
		
		arrayList.reset();
		arrayListTest = new MyArrayListTest();
		results = arrayListTest.testMe(arrayList, results);
		results.writeToStdout(results.getOutputString().toString());
	}
	
}