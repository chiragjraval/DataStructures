package com.chirag.ds.experimental.tree;

public interface OrderedBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {

	boolean addNode(T node);

}
