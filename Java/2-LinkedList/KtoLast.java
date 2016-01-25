import java.util.Scanner;

/***
 * Return Kth to last element Linked list size is unknown
 * 
 * @author Dhaval
 *
 */
public class KtoLast {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter String");
		String input = sc.next();

		LinkedList list = new LinkedList();
		for (char i : input.toCharArray()) {
			list.addElementAtEnd(new Character(i));
		}

		System.out.println("Enter k for kth to last position");
		int k = sc.nextInt();

		Node ktoLast = returnKtoLast(list, k);
		if (ktoLast == null)
			System.out.println("Not enough elements in List!");
		else
			System.out.println(k + " to last element " + ktoLast.getData());

		sc.close();
	}

	/**
	 * Returns Kth to last element
	 * 
	 */
	public static Node returnKtoLast(LinkedList list, int k) {
		if (list == null)
			return null;

		Node node1 = list.getFirst();
		Node node2 = list.getFirst();

		// Keep 2 pointers separated by k.
		for (int i = 0; i < k; i++) {
			if (node2 == null)
				return null;
			node2 = node2.getNext();
		}

		// Increment the two pointers till the leading pointer finishes
		// traversing the linked list. Trailing pointer will yield the Kth to
		// last element
		while (node2 != null) {
			node1 = node1.getNext();
			node2 = node2.getNext();
		}

		return node1;
	}

}
