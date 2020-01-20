package com.chirag.ds.tree.impl;

import com.chirag.ds.model.AbstractBaseNode;
import com.chirag.ds.model.BaseNode;

public class TreeNode<T> extends AbstractBaseNode<T> implements BaseNode<T> {

	protected BinaryTreeNode<T> parent = null;
	protected EdgeType parentNodeEdge;

	protected TreeNode() {
		super();
		this.data = null;
	}

	protected TreeNode(T data) {
		super();
		this.data = data;
	}
	
	protected void free() {
		this.parent = null;
		this.parentNodeEdge = null;
	}

	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}

	public EdgeType getParentNodeEdge() {
		return parentNodeEdge;
	}

	public void setParentNodeEdge(EdgeType parentNodeEdge) {
		this.parentNodeEdge = parentNodeEdge;
	}
}
