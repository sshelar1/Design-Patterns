package maxKVisitors.util;

import java.util.ArrayList;

public class MyArray implements ADT_Interface, VisitorI{

	ArrayList<Integer> integers;
	public MyArray() {
		// TODO Auto-generated constructor stub
		MyLogger.writeMessage("MyArray constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		integers = new ArrayList<Integer>();
	}
	
	@Override
	public void addData(int data) {
		// TODO Auto-generated method stub
		integers.add(data);
	}

	@Override
	public void visit(ADT_Interface adt) {
		// TODO Auto-generated method stub
		
	}

	public void accept(VisitorI visitorI) {
		// TODO Auto-generated method stub
		visitorI.visit(this);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return integers.size();
	}

	@Override
	public int getElement(int index) {
		// TODO Auto-generated method stub
		return integers.get(index);
	}

	@Override
	public void setElement(int index, int data) {
		// TODO Auto-generated method stub
		integers.set(index, data);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < integers.size(); i++) {
			builder.append(integers.get(i) + " ");
		}
		return builder.toString();
	}
}
