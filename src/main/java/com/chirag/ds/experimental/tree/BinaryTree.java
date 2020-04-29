package com.chirag.ds.experimental.tree;

public interface BinaryTree<T> extends Tree<T> {

	T getLeftChild(T node);
	
	T getRightChild(T node);
	
}
