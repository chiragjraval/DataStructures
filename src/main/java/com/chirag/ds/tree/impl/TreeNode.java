package com.chirag.ds.tree.impl;

import com.chirag.ds.model.BaseNode;

class TreeNode<T> extends BaseNode<T> {
	
	private TreeNode<T> left = null;
	private TreeNode<T> right = null;
	private TreeNode<T> parent = null;
	private EdgeType parentNodeEdge;
	
	protected TreeNode() {
		super();
		this.data = null;
	}
	
	protected TreeNode(T data) {
		super();
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", parentNodeEdge=" + parentNodeEdge + "]";
	}

	protected void free() {
		this.data = null;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.parentNodeEdge = null;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public EdgeType getParentNodeEdge() {
		return parentNodeEdge;
	}

	public void setParentNodeEdge(EdgeType parentNodeEdge) {
		this.parentNodeEdge = parentNodeEdge;
	}
}
