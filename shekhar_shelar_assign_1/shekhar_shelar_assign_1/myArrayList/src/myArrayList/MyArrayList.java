package myArrayList;

public class MyArrayList{

	private int[] myarray;
	private int size;
	
	/**
	 * default constructor which sets the private data members to the default values
	 */
	public MyArrayList() {
		myarray = new int [50];
		size=0;
	}
	
	/**
	 * this method returns the size 
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * this method returns the sum of numbers present in the array
	 * @return
	 */
	public int sum() {
		int sum=0;
		for (int i = 0; i < size; i++) {
			sum = sum + myarray[i];
		}
		return sum;
	}
	
	/**
	 * this method is used to insert the values in the array in sorted order
	 * @param newValue
	 */
	public void insertSorted(int newValue) {
		if (newValue<0 || newValue>10000) {
			return;
		}
		if (size==0) {
			myarray[size] = newValue;
			size++;
			return;
		}
		int x = size-1;
		while (x >= 0 && myarray[x] > newValue ) {
			myarray[x+1] = myarray[x];
			x--;
		}
        myarray[x+1] = newValue;	
        size++;
        if (size==myarray.length) {
			resize();
		}
	}
	
	/**
	 * This method is used for resizing the array to the original size
	 */
	private void resize() {
		// TODO Auto-generated method stub
		int newSize = (int) (size + Math.floor(size/2));
		int[] newMyArray = new int [newSize];
		for (int i = 0; i < size; i++) {
			newMyArray[i] = myarray[i];
		}
		myarray = newMyArray;
	}
	/**
	 * This method is used to remove the element from the array or input file
	 * @param value
	 */
	public void removeValue(int value) {
		int pos;
		while ((pos = indexOf(value)) != -1) {
			//System.out.println("Position : " + pos);
			for (int i = pos; i < size; i++) {
				myarray[i] = myarray[i+1];
			}
			myarray[size-1] = 0;
			size--;
		}
	}
	/**
	 * This method is used to give the position of element present in the array
	 * and it starts with 0
	 * @param value
	 * @return
	 */
	public int indexOf(int value) {
		// TODO Auto-generated method stub
		int pos = -1;
		for (int i = 0; i < size; i++) {
			if (myarray[i] == value) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	/**
	 * This method returns the string representation of the array list
	 */
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(myarray[i] + " ");
		}
		return builder.toString();
	}
	/**
	 * In this method if the size of the array goes beyond 50 and till 75
	 * it resets it to 50 again
	 */
	public void reset() {
		// TODO Auto-generated method stub
		myarray = new int [50];
		size = 0;
	}
}