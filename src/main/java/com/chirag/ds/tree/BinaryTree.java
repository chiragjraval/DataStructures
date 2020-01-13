package com.chirag.ds.tree;

import java.util.List;
import java.util.Optional;

public interface BinaryTree<T> extends Tree<T> {

	Optional<T> insert(T value);
	Optional<T> delete(T value);
	
	List<T> inOrderList();
	List<T> preOrderList();
	List<T> postOrderList();

	boolean isBinarySearchTree();
	Optional<T> findLca(T data1, T data2);
	int findShortestDistBetweenNodes(T data1, T data2);
	double findSumOfAllAtLevel(int level);
	int findDiameterOfTree();
	
}
