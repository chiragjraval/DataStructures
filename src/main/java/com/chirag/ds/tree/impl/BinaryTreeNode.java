package com.chirag.ds.tree.impl;

class BinaryTreeNode<T> extends TreeNode<T> {
	
	private BinaryTreeNode<T> left = null;
	private BinaryTreeNode<T> right = null;
	
	protected BinaryTreeNode() {
		super();
		this.data = null;
	}
	
	protected BinaryTreeNode(T data) {
		super();
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", parentNodeEdge=" + parentNodeEdge + "]";
	}

	@Override
	protected void free() {
		super.free();
		this.data = null;
		this.left = null;
		this.right = null;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
}
