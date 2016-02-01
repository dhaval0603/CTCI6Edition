package chap4;

public class BinaryTree {
	public BinaryTreeNode root;

	public BinaryTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		insertInOrder(data, root);
	}

	private void insertInOrder(int data, BinaryTreeNode node) {
		if (root == null) {
			root = new BinaryTreeNode(data);
		} else {
			if (data < node.data) {
				// Insert in Left subtree
				if (node.left == null)
					node.left = new BinaryTreeNode(data);
				else
					insertInOrder(data, node.left);

			} else {
				// Insert in Right subtree
				if (node.right == null)
					node.right = new BinaryTreeNode(data);
				else
					insertInOrder(data, node.right);
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

	public void preOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	public void postOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
		}
	}

}
