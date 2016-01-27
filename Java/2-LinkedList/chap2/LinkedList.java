package chap2;

public class LinkedList {
	Node head;
	int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void addElementAtEnd(Object data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node current = head;
			while (current.getNext() != null)
				current = current.getNext();
			Node newElement = new Node(data);
			current.setNext(newElement);
		}
		this.size++;
	}

	public void addElementAtStart(Object data) {
		if (head == null)
			head = new Node(data);
		else {
			Node newElement = new Node(data, head);
			head = newElement;
		}
		this.size++;
	}

	public void addElementAtPosition(Object data, int position) {
		if (this.size < position - 1 || position < 1) {
			System.out.println("Invalid position.");
		} else {
			Node newElement = new Node(data);
			if (position == 1) {
				newElement.setNext(head);
				head = newElement;
			} else {
				Node current = head;
				for (int i = 1; i < position - 1; i++) {
					current = current.getNext();
				}
				newElement.setNext(current.getNext());
				current.setNext(newElement);
			}
			this.size++;
		}
	}

	public Object deleteFromStart() {
		Node removed = head;

		if (head == null) {
			System.out.println("List Empty");
		} else {
			head = head.getNext();
			this.size--;
		}

		return removed.getData();
	}

	public Object deleteFromEnd() {
		Node removed = head;

		if (head == null) {
			System.out.println("List Empty");
		} else {
			if (this.size == 1) {
				head = null;
			} else {
				Node current = head;
				while (current.getNext().getNext() != null) {
					current = current.getNext();
				}
				current.setNext(null);
			}
			this.size--;
		}

		return removed.getData();
	}

	public Node getLast() {
		if (head == null)
			return null;

		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}

		return current;
	}

	public Node getFirst() {
		if (head == null)
			return null;
		return head;
	}

	public LinkedList clone() {
		LinkedList clone = new LinkedList();

		Node current = this.head;

		while (current != null) {
			clone.addElementAtEnd(current.getData());
			current=current.getNext();
		}

		return clone;
	}

	public int size() {
		return this.size;
	}

	public void display() {
		if (head == null) {
			System.out.println("List Empty");
		} else {
			Node current = head;
			while (current.getNext() != null) {
				System.out.print(current.getData() + " --> ");
				current = current.getNext();
			}
			System.out.println(current.getData());
		}
	}

}

