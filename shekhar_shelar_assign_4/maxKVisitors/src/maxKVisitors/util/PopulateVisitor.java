package maxKVisitors.util;

public class PopulateVisitor implements VisitorI{

	private FileProcessor fileProcessor;
	
	public PopulateVisitor() {
		// TODO Auto-generated constructor stub
		MyLogger.writeMessage("PopulateVisitor constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public PopulateVisitor(FileProcessor fileProcessorIn) {
		// TODO Auto-generated constructor stub
		fileProcessor = fileProcessorIn;
	}
	
	@Override
	public void visit(ADT_Interface adt) {
		// TODO Auto-generated method stub
		MyLogger.writeMessage("Applying the PopulateVisitor", MyLogger.DebugLevel.APPLYINGVISITORS);
		Integer integer;
		while((integer = fileProcessor.nextInt())!=null) {
			adt.addData(integer);
		}
	}

}
