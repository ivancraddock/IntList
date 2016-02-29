package com.intlist;

/* Ivan Craddock  
 * CSCD 211 Final Assignment: Linked Lists
 * 
 * This program demonstrates several operations from a user-defined LinkedList class.
 * 
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListTester {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		// go is a static boolean for determining menu functioning
		while (go == true) {
			int choice = opMenu(kb);
			listRunner(choice);
		}

	}// end of Main Function
		// Static variables for use in program

	public static IntNodeList prime = new IntNodeList();
	public static boolean go = true;
	private static Scanner kb;
	private static Scanner kb2;

	// method for displaying menu destinations
	public static void showMenu() {
		System.out.println("------------------------------------------------------");
		System.out.println("Please Select One of the Following");
		System.out.println("------------------------------------------------------");
		System.out.println("1.) Create a New List of Random Integers (Will Overwrite Existing List)");
		System.out.println("2.) Sort List by Order of Descending Values");
		System.out.println("3.) Print List in Forward Order");
		System.out.println("4.) Print List in Reverse Order");
		System.out.println("5.) Display all Even Numbers in List");
		System.out.println("6.) Display List Entries at User Selected Interval");
		System.out.println("7.) Delete all Entries Containing User Selected Value");
		System.out.println("8.) Delete all Entries in List");
		System.out.println("9.) Quit");
		System.out.println("------------------------------------------------------");

	}

	// method for generating user input for menu
	public static int opMenu(Scanner kb) {
		int menuInt = 1;
		do {
			showMenu();
			try {
				menuInt = kb.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid entry, program terminating");
				break;
			} catch (Exception e) {
				System.out.println("An unspecified error has occurred, program terminating");
				break;
			}

			switch (menuInt) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 5;
			case 6:
				return 6;
			case 7:
				return 7;
			case 8:
				return 8;
			case 9:
				return 9;
			default:
				System.out.println("Invalid entry, please try again");
			}

		} while (true);

		return menuInt;
	}

	// method for determining how to use user input
	public static void listRunner(int i) {
		if (i <= 1) {
			newList();
		}
		if (i == 2) {
			sortList(prime);
		}
		if (i == 3) {
			System.out.println(prime);
		}
		if (i == 4) {
			System.out.println(reverseList(prime.getList()));
		}
		if (i == 5) {
			evenList();
		}
		if (i == 6) {
			intervalList();
		}
		if (i == 7) {
			deleteList();
		}
		if (i == 8) {
			clearList();
		}
		// terminal conditions
		if (i >= 9) {
			go = false;
		}
	}

	// method for creating new list.
	public static void newList() {
		prime = new IntNodeList();
		int length = positive();
		for (int i = 0; i < length; i++) {
			IntNode n = new IntNode();
			prime.addNode(n);
		}
	}

	public static void sortList(IntNodeList list) {
		if (prime.getList() != null) {
			IntNode counter = list.getList();
			IntNode current = list.getList();
			IntNode next;
			int length = 1;
			while (counter.getNext() != null) {
				length++;
				counter = counter.getNext();
			}

			int[] ara1 = new int[length];
			for (int i = 0; i < length; i++) {
				ara1[i] = current.getValue();
				current = current.getNext();

			}
			ara1 = araSorter(ara1);

			prime = new IntNodeList();
			for (int j = 0; j < ara1.length; j++) {
				next = new IntNode(ara1[j]);
				prime.addNode(next);

			}
		}
		System.out.println();
	}

	public static void forwardList() {
		System.out.println("forwardList");
	}

	public static void evenList() {
		IntNode n = prime.getList();
		if (n != null) {
			while (n.getNext() != null) {
				if (n.getValue() % 2 == 0) {
					System.out.println(n);
				}
				n = n.getNext();
			}
			if (n.getValue() % 2 == 0) {
				System.out.println(n);
			}
		}
		System.out.println();
		// while (n.getNext() != void)
	}

	public static void intervalList() {
		int i = positive();
		if (prime.getList() != null) {

			int counter = 1;
			IntNode n = prime.getList();
			// if(i == 1){
			// System.out.println(prime);
			// }
			do {
				if (counter % i == 0) {
					System.out.println(n);
				}
				n = n.getNext();
				counter++;

			} while (n.lastNode() == false);
			if (counter % i == 0) {
				System.out.println(n);
			}

		}
		System.out.println();
	}

	public static void deleteList() {

		int i = real();
		if (prime.getList() != null) {
			IntNode curr = prime.getList();
			IntNode prev;
			boolean smart = true;
			// if(curr.getValue() == i && curr.getNext() == null){
			// newList();
			// }
			do {
				prev = curr;
				if (prev.lastNode() == false) {
					curr = curr.getNext();
				}
				if (curr.getValue() == i) {
					prev.setNext(curr.getNext());
					curr.setNext(null);
					curr = prev.getNext();

				}

				if (prev.lastNode() == true) {
					smart = false;
				}

			} while (smart == true);
			System.out.println();
		}
	}

	public static void clearList() {
		prime = new IntNodeList();
		System.out.println();
	}

	public static int positive() {
		int pos = 0;
		kb = new Scanner(System.in);
		boolean loop = true;
		do {
			System.out.println("Please Enter a Positive Integer");
			try {
				pos = kb.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Entry (Not an Integer)");
				return positive();
			} catch (Exception e) {
				System.out.println("An Unspecified Error has Occurred, Please Try Again");
				break;
			}

			if (pos > 0) {
				loop = false;
			}
			if (pos <= 0) {
				System.out.println("Invalid Entry (Integer not Positive)");
			}

		} while (loop == true);

		return pos;
	}

	public static int real() {
		int pos = 0;
		kb2 = new Scanner(System.in);
		boolean loop = true;
		do {
			System.out.println("Please Enter an Integer");
			try {
				pos = kb2.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Entry (Not an Integer)");
				return positive();
			} catch (Exception e) {
				System.out.println("An Unspecified Error has Occurred, Please Try Again");
				break;
			}

			if (pos > 0 || pos <= 0) {
				loop = false;
			} else {
				System.out.println("Invalid Entry");
			}

		} while (loop == true);

		return pos;
	}

	public static int[] araSorter(int[] ara1) {
		int j;
		int temp;
		int i;

		for (j = 1; j < ara1.length; j++) {
			temp = ara1[j];
			for (i = j - 1; (i >= 0) && (ara1[i] < temp); i--) {
				ara1[i + 1] = ara1[i];
			}
			ara1[i + 1] = temp;
		}
		return ara1;
	}

	public static String reverseList(IntNode n) {
		if (n == null) {
			return "";
		}

		IntNode temp;
		String reverse = "";
		if (n.getNext() != null) {
			temp = n.getNext();
			reverse = (reverseList(temp) + n.getValue() + "\n");
		}
		if (n.getNext() == null) {
			return ("" + reverse + n.getValue() + "\n");
		}

		return reverse;
	}
}
