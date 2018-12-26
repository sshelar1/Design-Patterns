package maxKVisitors.util;

/**
 * Citation: https://www.geeksforgeeks.org/heap-sort/
 *
 */
public class MaxHeapVisitor implements VisitorI{

	private FileProcessor fileProcessor;
	
	public MaxHeapVisitor(FileProcessor fileProcessorIn) {
		// TODO Auto-generated constructor stub
		MyLogger.writeMessage("MaxHeapVisitor constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		fileProcessor = fileProcessorIn;
	}

	@Override
	public void visit(ADT_Interface adt) {
		// TODO Auto-generated method stub
		MyLogger.writeMessage("Applying the MaxHeapVisitor", MyLogger.DebugLevel.APPLYINGVISITORS);
		Integer integer;
		while((integer = fileProcessor.nextInt())!=null) {
			adt.addData(integer);
		}
		heapSort(adt);
	}

	private void heapSort(ADT_Interface adt) {
		// TODO Auto-generated method stub
		int n = adt.getSize();
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(adt, n, i);
		}
		
		for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = adt.getElement(0);
            adt.setElement(0, adt.getElement(i));
            adt.setElement(i, temp);
 
            // call max heapify on the reduced heap
            heapify(adt, i, 0);
        }
	}

	private void heapify(ADT_Interface adt, int n, int i) {
		// TODO Auto-generated method stub
		int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
        
     // If left child is larger than root
        if (l < n && adt.getElement(l) > adt.getElement(largest))
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && adt.getElement(r) > adt.getElement(largest))
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int temp = adt.getElement(i);
			adt.setElement(i, adt.getElement(largest));
			adt.setElement(largest, temp);
			
            // Recursively heapify the affected sub-tree
            heapify(adt, n, largest);
        }
	}

}
