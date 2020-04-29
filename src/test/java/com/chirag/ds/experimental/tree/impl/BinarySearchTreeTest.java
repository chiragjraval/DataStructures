package com.chirag.ds.experimental.tree.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.chirag.ds.experimental.tree.OrderedBinaryTree;

public class BinarySearchTreeTest {

	@Test
	public void testBinaryTreeNegativeCases() {
		Integer root = 50;
		OrderedBinaryTree<Integer> tree = new BinarySearchTree<Integer>(root);
		
		assertNull(tree.getLeftChild(20));
		assertNull(tree.getRightChild(20));
		assertNull(tree.getChildren(20));
		assertFalse(tree.addNode(50));
	}
	
	@Test
	public void testBinaryTreePositiveCases() {
		Integer root = 50;
		Integer leftChild = 20;
		Integer rightChild = 80;
		OrderedBinaryTree<Integer> tree = new BinarySearchTree<Integer>(root);
		tree.addNode(leftChild);
		tree.addNode(rightChild);
		
		assertEquals(root, tree.getRoot());
		assertEquals(leftChild, tree.getLeftChild(root));
		assertEquals(rightChild, tree.getRightChild(root));
		assertEquals(Arrays.asList(leftChild, rightChild), tree.getChildren(root));
		assertTrue(tree.addNode(10));
		assertEquals(new Integer(10), tree.getLeftChild(leftChild));
	}
}
