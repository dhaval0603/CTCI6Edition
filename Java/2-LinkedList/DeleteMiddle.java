import java.util.Scanner;

/***
 * Delete a given node without traversing through the linkedlist. Node will
 * always lie in the middle of the linked list
 * 
 * @author Dhaval
 *
 */
public class DeleteMiddle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string to be converted into Linked List : ");
		String input = sc.next();

		LinkedList list = new LinkedList();
		for (char i : input.toCharArray()) {
			list.addElementAtEnd(new Character(i));
		}

		Node head = list.getFirst();
		deleteSpecific(head.getNext().getNext().getNext());

		list.display();

		sc.close();

	}

	/**
	 * Delete the given node without traversing through the List
	 * 
	 * @param x
	 */
	public static void deleteSpecific(Node x) {
		if (x == null) {
			System.out.println("Invalid Node");
		} else {
			// Copy the value of the next node in the current node and delete
			// the next node
			x.setData(x.getNext().getData());
			x.setNext(x.getNext().getNext());
		}

	}

}
