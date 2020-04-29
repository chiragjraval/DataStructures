package com.chirag.ds.experimental.tree.impl;

import static java.util.Objects.nonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chirag.ds.experimental.tree.OrderedBinaryTree;

public class BinarySearchTree<T extends Comparable<T>> implements OrderedBinaryTree<T> {

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

	public BinarySearchTree(T root) {
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
	public boolean addNode(T node) {
		if (!nodeToPropsMap.containsKey(node)) {
			T parentNode = root;
			T currentNode = root;
			while (nonNull(currentNode)) {
				parentNode = currentNode;
				if (currentNode.compareTo(node) >= 0) {
					currentNode = nodeToPropsMap.get(currentNode).getLeftChild();
				} else {
					currentNode = nodeToPropsMap.get(currentNode).getRightChild();
				}
			}

			if (parentNode.compareTo(node) >= 0) {
				nodeToPropsMap.get(parentNode).setLeftChild(node);
			} else {
				nodeToPropsMap.get(parentNode).setRightChild(node);
			}
			this.nodeToPropsMap.put(node, new NodeProps<T>());
			return true;
		}
		return false;
	}
}
