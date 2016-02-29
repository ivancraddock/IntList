package com.intlist;

public class IntNodeList {

	private IntNode list;

	public IntNodeList() {
		list = null;
	}// end DVC

	public IntNode getList() {
		return this.list;
	}

	public void addNode(IntNode n) {
		IntNode current;
		if (list == null) {
			list = n;
		} // end IF
		else {
			current = list;
			while (current.getNext() != null) {
				current = current.getNext();
			} // end while
			current.setNext(n);

		} // end else

	}// end addNode

	@Override
	public String toString() {
		String result = "";
		IntNode current = list;
		while (current != null) {
			result += current.toString() + "\n";
			current = current.getNext();
		} // end while

		return result;
	}// end toString

}// end class