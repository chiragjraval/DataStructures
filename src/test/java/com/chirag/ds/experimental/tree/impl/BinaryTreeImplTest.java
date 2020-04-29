package com.chirag.ds.experimental.tree.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.chirag.ds.experimental.tree.UnorderedBinaryTree;

public class BinaryTreeImplTest {

	@Test
	public void testBinaryTreeNegativeCases() {
		Integer root = 50;
		UnorderedBinaryTree<Integer> tree = new BinaryTreeImpl<Integer>(root);
		
		assertNull(tree.getLeftChild(20));
		assertNull(tree.getRightChild(20));
		assertNull(tree.getChildren(20));
		assertFalse(tree.addLeftChild(20, 10));
		assertFalse(tree.addRightChild(20, 30));
	}
	
	@Test
	public void testBinaryTreePositiveCases() {
		Integer root = 50;
		Integer leftChild = 20;
		Integer rightChild = 80;
		UnorderedBinaryTree<Integer> tree = new BinaryTreeImpl<Integer>(root);
		tree.addLeftChild(root, leftChild);
		tree.addRightChild(root, rightChild);
		
		assertEquals(root, tree.getRoot());
		assertEquals(leftChild, tree.getLeftChild(root));
		assertEquals(rightChild, tree.getRightChild(root));
		assertEquals(Arrays.asList(leftChild, rightChild), tree.getChildren(root));
		assertTrue(tree.addLeftChild(20, 10));
		assertTrue(tree.addRightChild(20, 30));
	}
}
