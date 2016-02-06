package chap3;

import chap2.Node;

public class Queue {
	Node head;
	int size;

	public Queue() {
		head = null;
		size = 0;
	}

	public void enqueue(Object data) {
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



	public Object dequeue() {
		Node removed = head;

		if (head == null) {
			System.out.println("Queue Empty");
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
			System.out.println("Queue Empty");
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

