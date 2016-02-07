package chap4;

public class BinarySearchTree {
	public BinaryTreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean remove(int data) {
		if (root == null)
			return false;
		else {
			BinaryTreeNode current = root;
			BinaryTreeNode parent = root;
			// isLeft is used to track if the node to be deleted is on the
			// left/right of the parent
			boolean isLeft = true;
			// Search
			while (current.data != data) {
				parent = current;
				if (data < current.data) {
					current = current.left;
					isLeft = true;
				} else if (data > current.data) {
					current = current.right;
					isLeft = false;
				}

				if (current == null)
					return false;
			}

			// If leaf node to be deleted
			if (current.left == null && current.right == null) {
				if (isLeft)
					parent.left = null;
				else
					parent.right = null;
			}
			// If node to be deleted has a single Left child
			else if (current.left != null && current.right == null) {
				if (isLeft)
					parent.left = current.left;
				else
					parent.right = current.left;
			}
			// If node to be deleted has a single right child
			else if (current.left == null && current.right != null) {
				if (isLeft)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
			// If Two children present
			else if (current.left != null && current.right != null) {
				BinaryTreeNode rightCurrent = current.right;
				BinaryTreeNode rightParent = current.right;

				// If left of right child is null, move right subtree to the
				// position of node to be deleted
				if (rightCurrent.left == null) {
					current.data = rightCurrent.data;
					current.right = rightCurrent.right;
				} else {
					// Else take the left most element of the right subtree and
					// move it to the position of the ode to be deleted
					while (rightCurrent.left != null) {
						rightParent = rightCurrent;
						rightCurrent = rightCurrent.left;
					}

					current.data = rightCurrent.data;
					rightParent.left = null;

				}
			}
			return true;
		}
	}

	public boolean search(int data) {
		if (root == null)
			return false;
		else {
			BinaryTreeNode current = root;
			while (true) {
				if (data < current.data) {
					current = current.left;
				} else if (data > current.data) {
					current = current.right;
				} else {
					return true;
				}

				if (current == null)
					return false;
			}
		}
	}

	public void insertIterative(int data) {

		if (root == null)
			root = new BinaryTreeNode(data);
		else {
			BinaryTreeNode current = root;
			BinaryTreeNode parent;
			while (true) {
				parent = current;
				if (data <= current.data) {
					current = current.left;
					if (current == null) {
						parent.left = new BinaryTreeNode(data);
						return;
					}
				} else if (data > current.data) {
					current = current.right;
					if (current == null) {
						parent.right = new BinaryTreeNode(data);
						return;
					}
				}
			}
		}
	}

	public void insertRecursive(int data, BinaryTreeNode node) {
		if (root == null) {
			root = new BinaryTreeNode(data);
		} else {
			if (data < node.data) {
				// Insert in Left subtree
				if (node.left == null)
					node.left = new BinaryTreeNode(data);
				else
					insertRecursive(data, node.left);

			} else {
				// Insert in Right subtree
				if (node.right == null)
					node.right = new BinaryTreeNode(data);
				else
					insertRecursive(data, node.right);
			}
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

}
