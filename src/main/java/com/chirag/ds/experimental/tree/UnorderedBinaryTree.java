package com.chirag.ds.experimental.tree;

public interface UnorderedBinaryTree<T> extends BinaryTree<T> {

	boolean addLeftChild(T parent, T node);

	boolean addRightChild(T parent, T node);

}
