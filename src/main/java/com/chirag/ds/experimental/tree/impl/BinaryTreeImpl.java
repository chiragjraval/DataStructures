package com.chirag.ds.experimental.tree.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chirag.ds.experimental.tree.UnorderedBinaryTree;

public class BinaryTreeImpl<T> implements UnorderedBinaryTree<T> {

	@SuppressWarnings("hiding")
	class NodeProps<T> {
		T leftChild;
		T rightChild;

		public T getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(T leftChild) {
			this.leftChild = leftChild;
		}

		public T getRightChild() {
			return rightChild;
		}

		public void setRightChild(T rightChild) {
			this.rightChild = rightChild;
		}

		public List<T> getChildren() {
			return Arrays.asList(leftChild, rightChild);
		}
	}

	private T root;

	private Map<T, NodeProps<T>> nodeToPropsMap = new HashMap<>();

	public BinaryTreeImpl(T root) {
		super();
		this.root = root;
		this.nodeToPropsMap.put(this.root, new NodeProps<T>());
	}

	@Override
	public T getRoot() {
		return root;
	}

	@Override
	public T getLeftChild(T node) {
		if (nodeToPropsMap.containsKey(node)) {
			return nodeToPropsMap.get(node).getLeftChild();
		}
		return null;
	}

	@Override
	public T getRightChild(T node) {
		if (nodeToPropsMap.containsKey(node)) {
			return nodeToPropsMap.get(node).getRightChild();
		}
		return null;
	}

	@Override
	public List<T> getChildren(T node) {
		if (nodeToPropsMap.containsKey(node)) {
			return nodeToPropsMap.get(node).getChildren();
		}
		return null;
	}

	@Override
	public boolean addLeftChild(T parent, T node) {
		if(nodeToPropsMap.containsKey(parent)) {
			nodeToPropsMap.get(parent).setLeftChild(node);
			this.nodeToPropsMap.put(node, new NodeProps<T>());
			return true;
		}
		return false;
	}

	@Override
	public boolean addRightChild(T parent, T node) {
		if(nodeToPropsMap.containsKey(parent)) {
			nodeToPropsMap.get(parent).setRightChild(node);
			this.nodeToPropsMap.put(node, new NodeProps<T>());
			return true;
		}
		return false;
	}
}
