import java.util.HashSet;
import java.util.Scanner;

/***
 * Remove duplicates from a linked list. With and without extra buffer space.
 * 
 * @author Dhaval
 *
 */
public class RemoveDups {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string to be converted into char linked list");
		String input = sc.next();

		LinkedList list = new LinkedList();
		for (char i : input.toCharArray()) {
			list.addElementAtEnd(new Character(i));
		}

		LinkedList list1 = list.clone();
		System.out.print("Remove Dups with Buffer space : ");
		removeDupsWithBuffer(list1).display();

		LinkedList list2 = list.clone();
		System.out.print("Remove Dups without Buffer space : ");
		removeDupsWithoutBuffer(list2).display();

		sc.close();
	}

	/**
	 * Uses HashSet as the extra storage space
	 * 
	 * @param list
	 * @return
	 */
	public static LinkedList removeDupsWithBuffer(LinkedList list) {
		HashSet<Object> bufferHash = new HashSet<Object>();

		Node current = list.getFirst();
		Node previous = null;

		while (current != null) {
			// If Hashset contains the element, delete the current element
			// Else add to the hashset and move forward
			if (bufferHash.contains(current.getData())) {
				previous.setNext(current.getNext());
			} else {
				bufferHash.add(current.getData());
				previous = current;
			}
			current = current.getNext();
		}
		return list;
	}

	/**
	 * Does not use any buffer space
	 * 
	 * @param list
	 * @return
	 */
	public static LinkedList removeDupsWithoutBuffer(LinkedList list) {
		if (list == null)
			return null;

		Node current = list.getFirst();

		// Iterate over the linkedlist
		// Run an iterator from the current node to delete any duplicate values
		while (current != null) {
			Node iterator = current;
			while (iterator.getNext() != null) {
				if (iterator.getNext().getData().equals(current.getData())) {
					iterator.setNext(iterator.getNext().getNext());
				} else {
					iterator = iterator.getNext();
				}
			}
			current = current.getNext();
		}

		return list;
	}
}
