package chap4;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
