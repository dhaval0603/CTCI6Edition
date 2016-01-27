package chap2;

import java.util.Scanner;

import chap2.LinkedList;
import chap2.Node;

/***
 * Partition the linked list around the given node. Elements less than x on the
 * left Elements greater than equal to x on the right
 * 
 * @author Dhaval
 *
 */
public class Partition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Number of elements?");
		int n = sc.nextInt();

		System.out.println("Enter elements");
		LinkedList list = new LinkedList();
		for (int i = 0; i < n; i++) {
			list.addElementAtEnd(sc.nextInt());
		}

		System.out.println("Enter partition element : ");
		Node partitionNode = new Node(sc.nextInt());

		list = partitionStable(list, partitionNode);

		list.display();

		sc.close();
	}

	/**
	 * Create two lists : Less than X and Greater than x Merge the two lists to
	 * get the partitioned list
	 * 
	 * @param list
	 * @param partitionNode
	 * @return
	 */
	public static LinkedList partitionStable(LinkedList list, Node partitionNode) {
		LinkedList partitionedList = new LinkedList();
		LinkedList beforeList = new LinkedList();
		LinkedList afterList = new LinkedList();

		Node current = list.getFirst();
		while (current != null) {
			if ((int) current.getData() < (int) partitionNode.getData()) {
				beforeList.addElementAtEnd(current.getData());
			} else if ((int) current.getData() > (int) partitionNode.getData()) {
				afterList.addElementAtEnd(current.getData());
			} else {
				afterList.addElementAtStart(current.getData());
			}
			current = current.getNext();
		}

		// Join the two lists
		if(beforeList.getLast()==null) {
			partitionedList = afterList;
		} else { 
			beforeList.getLast().setNext(afterList.getFirst());
			partitionedList = beforeList;
		}
		
		return partitionedList;
	}

}
