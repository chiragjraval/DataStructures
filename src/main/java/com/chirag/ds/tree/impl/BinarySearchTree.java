package com.chirag.ds.tree.impl;

import java.util.Objects;
import java.util.Optional;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {

	public BinarySearchTree() {
		super();
	}
	
	@Override
	protected Optional<BinaryTreeNode<T>> findNode(T value) {
		BinaryTreeNode<T> temp = this.root;
		while(Objects.nonNull(temp)) {
			if(temp.getData().compareTo(value)==0)
				break;
			else if(temp.getData().compareTo(value)>0)
				temp = temp.getLeft();
			else
				temp = temp.getRight();
		}
		return Optional.ofNullable(temp);
	}	
	
	protected BinaryTreeNode<T> findSmallestNode(BinaryTreeNode<T> node) {
		while(Objects.nonNull(node.getLeft()))
			node = node.getLeft();
		return node;
	}
	
	@Override
	public Optional<T> insert(T value) {
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value);
		BinaryTreeNode<T> node = this.root;
		BinaryTreeNode<T> parent = null;
		EdgeType parentNodeEdge = null;
		
		while(Objects.nonNull(node)) {
			if(node.getData().compareTo(value)==0) {
				return Optional.empty();
			}
			else if(node.getData().compareTo(value)>0) {
				parent = node;
				parentNodeEdge = EdgeType.LEFT;
				node = node.getLeft();
			}
			else {
				parent = node;
				parentNodeEdge = EdgeType.RIGHT;
				node = node.getRight();
			}
		}
		
		if(Objects.isNull(this.root)) {
			this.root = newNode;
		}
		else if(Objects.isNull(node)) {
			setChild(parent, newNode, parentNodeEdge);
		}
		
		return Optional.of(newNode.getData());
	}
	
	@Override
	public Optional<T> delete(T value) {
		Optional<BinaryTreeNode<T>> nodeOptional = findNode(value);
		if(nodeOptional.isPresent()) {
			BinaryTreeNode<T> node = nodeOptional.get();
			return Optional.of(delete(node));
		}
		return Optional.empty();
	}
	
	private T delete(BinaryTreeNode<T> node) {
		T returnValue = node.getData();
		BinaryTreeNode<T> parent = node.getParent();
		EdgeType parentNodeEdge = node.getParentNodeEdge();
		
		if(Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())) {
			setEdgeNull(parent, parentNodeEdge);
			node.free();
		}
		else if(Objects.nonNull(node.getLeft()) && Objects.nonNull(node.getRight())) {
			BinaryTreeNode<T> successor = findSmallestNode(node.getRight());
			node.setData(successor.getData());
			delete(successor);
		}
		else if(Objects.isNull(node.getLeft())) {
			BinaryTreeNode<T> child = node.getRight();
			setChild(parent, child, parentNodeEdge);
		}
		else if(Objects.isNull(node.getRight())) {
			BinaryTreeNode<T> child = node.getLeft();
			setChild(parent, child, parentNodeEdge);
		}
		
		return returnValue;
	}

	@Override
	public int getHeight() {
		return 0;
	}
	
}
