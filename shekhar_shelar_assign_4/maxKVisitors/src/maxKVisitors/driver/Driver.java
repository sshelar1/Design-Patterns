package maxKVisitors.driver;

import maxKVisitors.util.FileProcessor;
import maxKVisitors.util.MaxHeapVisitor;
import maxKVisitors.util.ModifiedBubbleSortVisitor;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyLogger;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.PopulateVisitor;
import maxKVisitors.util.Results;

public class Driver{

	public static void main(String[] args) {
		
		FileProcessor fileProcessor = null;
		Results results = null;
		int debugLevel=-1;
		
		/**
		 * Checking for valid arguments i.e 3
		 */
		if (args.length != 3) {
			System.out.println("Invaid number of arguments");
			System.exit(1);
		}
		
		/**
		 * Checking for valid debug level
		 */
		try {
			debugLevel = Integer.parseInt(args[2]);
			MyLogger.setDebugValue(debugLevel);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid debug level");
			System.exit(1);
		}
		
		/**
		 * Checks if the debug level is in range or not
		 */
		if (debugLevel < 0 || debugLevel > 3) {
			System.out.println("Debug value out of range");
			System.exit(1);
		}
		
		results = new Results(args[1]);
		PopulateVisitor populateVisitor=null;
		
		//Logic for first visitor for populateVisitor and bubbleSortVisitor
		MyArray myArray_modifiedBubbleSort = new MyArray();
		MyVector myVector_modifiedBubbleSort = new MyVector();
		ModifiedBubbleSortVisitor bubbleSortVisitor = new ModifiedBubbleSortVisitor();

		fileProcessor = new FileProcessor(args[0]);
		populateVisitor = new PopulateVisitor(fileProcessor);
		myArray_modifiedBubbleSort.accept(populateVisitor);
		myArray_modifiedBubbleSort.accept(bubbleSortVisitor);
		fileProcessor.close();
		
		fileProcessor = new FileProcessor(args[0]);
		populateVisitor = new PopulateVisitor(fileProcessor);
		myVector_modifiedBubbleSort.accept(populateVisitor);
		myVector_modifiedBubbleSort.accept(bubbleSortVisitor);
		fileProcessor.close();
		
		//Logic for second visitor for maxHeapVisitor
		MaxHeapVisitor maxHeapVisitor;
		MyArray myArray_heapSort = new MyArray();
		MyVector myVector_heapSort = new MyVector();
		
		fileProcessor = new FileProcessor(args[0]);
		maxHeapVisitor = new MaxHeapVisitor(fileProcessor);
		myArray_heapSort.accept(maxHeapVisitor);
		fileProcessor.close();
		
		fileProcessor = new FileProcessor(args[0]);
		maxHeapVisitor = new MaxHeapVisitor(fileProcessor);
		myVector_heapSort.accept(maxHeapVisitor);
		fileProcessor.close();
		
		//Logic for writing output to file as well as standard output 
		results.storeNewResult(myArray_modifiedBubbleSort.toString());
		results.storeNewResult(myVector_modifiedBubbleSort.toString());
		results.storeNewResult(myArray_heapSort.toString());
		results.storeNewResult(myVector_heapSort.toString());
		results.writeToFile();
		results.writeToStdout();
	}
	
}