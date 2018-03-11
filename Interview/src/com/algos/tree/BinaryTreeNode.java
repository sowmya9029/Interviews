package com.algos.tree;



public class BinaryTreeNode {

	BinaryTreeNode right;
	BinaryTreeNode left;
	int data;
	public BinaryTreeNode(int data) {
		this.data=data;
		right =null;
		left=null;
		// TODO Auto-generated constructor stub
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

}
