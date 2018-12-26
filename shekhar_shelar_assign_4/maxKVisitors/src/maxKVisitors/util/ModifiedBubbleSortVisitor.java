package maxKVisitors.util;

public class ModifiedBubbleSortVisitor implements VisitorI{

	public ModifiedBubbleSortVisitor() {
		// TODO Auto-generated constructor stub
		MyLogger.writeMessage("ModifiedBubbleSortVisitor constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	@Override
	public void visit(ADT_Interface adt) {
		// TODO Auto-generated method stub
		MyLogger.writeMessage("Applying the ModifiedBubbleSortVisitor", MyLogger.DebugLevel.APPLYINGVISITORS);
		bubbleSort(adt);
	}

	private void bubbleSort(ADT_Interface adt) {
		// TODO Auto-generated method stub
		int size = adt.getSize();
		for (int i = 0; i < size-1; i++) {
			for (int j = 0; j < size-i-1; j++) {
				if (adt.getElement(j) > adt.getElement(j+1)) {
					int temp = adt.getElement(j);
					adt.setElement(j, adt.getElement(j+1));
					adt.setElement(j+1, temp);
				}
			}
		}
	}

}
