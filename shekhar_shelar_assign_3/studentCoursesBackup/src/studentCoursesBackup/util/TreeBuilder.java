package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {

	private BST bst, bstBackUp1, bstBackUp2;
	
	public TreeBuilder(BST bstIn, BST bstBackUp1In, BST bstBackUp2In) {
		// TODO Auto-generated constructor stub
		
		MyLogger.writeMessage("In TreeBuilder constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		setBst(bstIn);
		setBstBackUp1(bstBackUp1In);;
		setBstBackUp2(bstBackUp2In);
	}

	public BST getBst() {
		return bst;
	}

	public void setBst(BST bst) {
		this.bst = bst;
	}

	public BST getBstBackUp1() {
		return bstBackUp1;
	}

	public void setBstBackUp1(BST bstBackUp1) {
		this.bstBackUp1 = bstBackUp1;
	}

	public BST getBstBackUp2() {
		return bstBackUp2;
	}

	public void setBstBackUp2(BST bstBackUp2) {
		this.bstBackUp2 = bstBackUp2;
	}

	public void insert(int b_numberIn, Character courseIn) {
		// TODO Auto-generated method stub
		Node node = new Node();
		ArrayList<Character> arrayList = new ArrayList<Character>();
		boolean flag = node.validate(courseIn);
		if (flag) {
			arrayList.add(courseIn);
			node.setB_number(b_numberIn);
			node.setCourseList(arrayList);
			
			try {
				Node backup1 = (Node) node.clone();
				Node backup2 = (Node) node.clone();
				node.registerObserver(backup1);
				node.registerObserver(backup2);
				bst.insert(node);
				bstBackUp1.insert(backup1);
				bstBackUp2.insert(backup2);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.exit(1);
			}
			
		}
	}	
	
	public void delete(int b_numberIn, Character courseIn) {
		bst.delete(b_numberIn, courseIn);
	}
	
}
