package chap4;

import chap3.Queue;

public class BinaryTree {
	public BinaryTreeNode root;

	public BinaryTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		if (root == null) {
			root = new BinaryTreeNode(data);
			return;
		}

		BinaryTreeNode newNode = new BinaryTreeNode(data);

		Queue q = new Queue();
		q.enqueue(root);

		BinaryTreeNode temp;
		while (!q.isEmpty()) {
			temp = (BinaryTreeNode) q.dequeue();

			if (temp.left != null) {
				q.enqueue(temp.left);
			} else {
				temp.left = newNode;
				return;
			}

			if (temp.right != null) {
				q.enqueue(temp.right);
			} else {
				temp.right = newNode;
				return;
			}
		}
	}

	public int getMax() {
		int max = Integer.MIN_VALUE;

		if (root == null)
			return 0;

		Queue q = new Queue();

		q.enqueue(root);

		BinaryTreeNode temp;
		while (!q.isEmpty()) {
			temp = (BinaryTreeNode) q.dequeue();

			if (temp.data > max)
				max = temp.data;

			if (temp.left != null)
				q.enqueue(temp.left);

			if (temp.right != null)
				q.enqueue(temp.right);
		}

		return max;
	}

	public int getMaxRecursive(BinaryTreeNode root) {
		int max = Integer.MIN_VALUE;

		if (root != null) {
			int leftMax = getMaxRecursive(root.left);
			int rightMax = getMaxRecursive(root.right);

			if (root.data > leftMax)
				max = root.data;
			else
				max = leftMax;
			if (rightMax > max)
				max = rightMax;
		}

		return max;

	}

	public boolean search(int data) {

		if (root == null)
			return false;
		else {
			Queue q = new Queue();
			q.enqueue(root);
			BinaryTreeNode temp;

			while (!q.isEmpty()) {
				temp = (BinaryTreeNode) q.dequeue();
				if (temp.data == data)
					return true;

				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);

			}
			return false;
		}
	}

	public boolean searchRecursive(int data, BinaryTreeNode root) {
		if (root != null) {
			if (root.data == data)
				return true;
			else {
				if (searchRecursive(data, root.left))
					return true;
				else if (searchRecursive(data, root.left))
					return true;
			}
		}
		return false;
	}

	public int size() {
		if (root == null)
			return 0;
		else {
			int size = 0;

			Queue q = new Queue();
			q.enqueue(root);

			BinaryTreeNode temp;

			while (!q.isEmpty()) {
				temp = (BinaryTreeNode) q.dequeue();
				size++;
				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			return size;
		}
	}

	public int sizeRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		else {
			return sizeRecursive(root.left) + sizeRecursive(root.right) + 1;
		}
	}

	public int heightRecursive(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = heightRecursive(root.left);
			int rightHeight = heightRecursive(root.right);

			if (leftHeight > rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}

	public int height() {
		if (root == null)
			return 0;
		else {
			int height = 0;

			Queue q = new Queue();
			q.enqueue(root);

			while (true) {
				int nodeCount = q.size();

				if (nodeCount == 0)
					return height;

				height++;

				BinaryTreeNode temp = null;
				while (nodeCount > 0) {
					if (!q.isEmpty())
						temp = (BinaryTreeNode) q.dequeue();
					if (temp != null && temp.left != null)
						q.enqueue(temp.left);
					if (temp != null && temp.right != null)
						q.enqueue(temp.right);
					nodeCount--;
				}
			}
		}
	}

	public BinaryTreeNode deepestNode() {

		if (root == null)
			return null;
		else {
			Queue q = new Queue();
			q.enqueue(root);

			BinaryTreeNode temp = null;

			while (!q.isEmpty()) {
				temp = (BinaryTreeNode) q.dequeue();
				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			return temp;
		}
	}

	public int numLeaves() {

		if (root == null)
			return 0;
		else {
			Queue q = new Queue();
			q.enqueue(root);
			int count = 0;
			BinaryTreeNode temp = null;

			while (!q.isEmpty()) {
				temp = (BinaryTreeNode) q.dequeue();

				if (temp.left == null && temp.right == null)
					count++;

				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			return count;
		}
	}

	public int numFullNodes() {

		if (root == null)
			return 0;
		else {
			Queue q = new Queue();
			q.enqueue(root);
			int count = 0;
			BinaryTreeNode temp = null;

			while (!q.isEmpty()) {
				temp = (BinaryTreeNode) q.dequeue();

				if (temp.left != null && temp.right != null)
					count++;

				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			return count;
		}
	}

	public int numOneLeaves() {

		if (root == null)
			return 0;
		else {
			Queue q = new Queue();
			q.enqueue(root);
			int count = 0;
			BinaryTreeNode temp = null;

			while (!q.isEmpty()) {
				temp = (BinaryTreeNode) q.dequeue();

				if ((temp.left == null && temp.right != null) || (temp.left != null && temp.right == null))
					count++;

				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			return count;
		}
	}

	public int sum() {

		if (root == null)
			return 0;
		else {
			Queue q = new Queue();
			q.enqueue(root);
			int sum = 0;
			BinaryTreeNode temp = null;

			while (!q.isEmpty()) {
				temp = (BinaryTreeNode) q.dequeue();

				sum = sum + temp.data;

				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			return sum;
		}
	}
	
	public int sumRecursion(BinaryTreeNode root) {

		if (root == null)
			return 0;
		else {
			return root.data + sumRecursion(root.left) + sumRecursion(root.right);
		}
	}
	
	public void rootToLeafPaths(BinaryTreeNode root, int[] path, int length) {
		if(root==null)
			return;
		path[length] = root.data;
		length++;
		
		if(root.left == null && root.right==null )
			print(path, length);
		else {
			rootToLeafPaths(root.left, path, length);
			rootToLeafPaths(root.right, path, length);
		}
		
	}
	
	public boolean identical(BinaryTree btree2) {
		if (root == null && btree2.root == null)
			return true;
		if ((root == null & btree2.root != null) || (root != null & btree2.root == null))
			return false;
		else {
			Queue q1 = new Queue();
			Queue q2 = new Queue();

			q1.enqueue(root);
			q2.enqueue(btree2.root);

			BinaryTreeNode temp1;
			BinaryTreeNode temp2;

			while (!q1.isEmpty() || !q2.isEmpty()) {
				temp1 = (BinaryTreeNode) q1.dequeue();
				temp2 = (BinaryTreeNode) q2.dequeue();

				if ((temp1.left == null) == (temp2.left == null)) {
					if (temp1.left != null) {
						q1.enqueue(temp1.left);
						q2.enqueue(temp2.left);
					}
				} else {
					return false;
				}

				if ((temp1.right == null) == (temp2.right == null)) {
					if (temp2.right != null) {
						q1.enqueue(temp1.right);
						q2.enqueue(temp2.right);
					}
				} else {
					return false;
				}
			}
			return true;
		}
	}

	public void inOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	public void postOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	public void preOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	private void print(int[] path, int index)  {
		for(int i = 0; i<index;i++) {
			System.out.print(path[i]+ " --> ");
		}
		System.out.println();
	}
}
