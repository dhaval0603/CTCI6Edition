package chap3;

import chap2.Node;

public class Stack {
	Node head;
	int size;

	public Stack() {
		head = null;
		size = 0;
	}

	public void push(Object data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node newElement = new Node(data);
			newElement.setNext(head);
			head = newElement;
		}
		this.size++;
	}



	public Object pop() {
		Node removed = head;

		if (head == null) {
			System.out.println("Stack Empty");
		} else {
			head = head.getNext();
			this.size--;
		}
		return removed.getData();
	}

	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public void display() {
		if (head == null) {
			System.out.println("Stack Empty");
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

