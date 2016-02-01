package chap4;

import java.util.Scanner;

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

	public void insertInOrder(int data, BinaryTreeNode node) {
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

	void inOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data+" ");
			inOrderTraversal(node.right);
		}
	}

	void preOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
			System.out.print(node.data+ " ");
		}
	}

	void postOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.data+ " ");
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BinaryTree btree = new BinaryTree();
		btree.insert(10);
		btree.insert(4);
		btree.insert(3);
		btree.insert(8);
		btree.insert(5);
		btree.insert(7);
		btree.insert(9);

		btree.inOrderTraversal(btree.root);
		System.out.println();
		btree.preOrderTraversal(btree.root);
		System.out.println();
		btree.postOrderTraversal(btree.root);
		sc.close();
	}
}
