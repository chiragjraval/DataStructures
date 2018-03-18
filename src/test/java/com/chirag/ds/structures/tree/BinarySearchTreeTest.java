package com.chirag.ds.structures.tree;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.chirag.ds.structures.tree.implementation.BinarySearchTree;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinarySearchTreeTest {

	@Test
	public void insertTest() { 
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		Assert.assertTrue(tree.inOrderList().equals(Arrays.asList(3, 10, 12)));
		
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		Assert.assertTrue(tree.inOrderList().equals(Arrays.asList(2, 3, 5, 10, 12, 14)));
	}
	
	@Test
	public void deleteTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		List<Integer> inOrderList;
		
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(inOrderList.equals(Arrays.asList(2, 3, 5, 10, 12, 14)));
		
		tree.delete(14);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(inOrderList.equals(Arrays.asList(2, 3, 5, 10, 12)));
		
		tree.delete(10);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(inOrderList.equals(Arrays.asList(2, 3, 5, 12)));
	}
	
	@Test
	public void inOrderListTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertTrue(tree.inOrderList().equals(Arrays.asList(2, 3, 5, 10, 12, 14)));
	}
	
	@Test
	public void preOrderListTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertTrue(tree.preOrderList().equals(Arrays.asList(10, 3, 2, 5, 12, 14)));
	}
	
	@Test
	public void postOrderListTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertTrue(tree.postOrderList().equals(Arrays.asList(2, 5, 3, 14, 12, 10)));
	}
	
	@Test
	public void isBinarySearchTreeTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertTrue(tree.isBinarySearchTree());
	}
	
	@Test
	public void findDiameterOfTreeTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertEquals(5, tree.findDiameterOfTree());
	}
	
	@Test
	public void findLcaTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertTrue(tree.findLca(14, 12).get().equals(12));
		Assert.assertTrue(tree.findLca(5, 12).get().equals(10));
		Assert.assertTrue(tree.findLca(12, 5).get().equals(10));
		Assert.assertTrue(tree.findLca(2, 5).get().equals(3));
	}
	
	@Test
	public void findShortestDistBetweenNodesTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertEquals(2, tree.findShortestDistBetweenNodes(2, 5));
		Assert.assertEquals(2, tree.findShortestDistBetweenNodes(2, 10));
		Assert.assertEquals(4, tree.findShortestDistBetweenNodes(2, 14));
		Assert.assertEquals(1, tree.findShortestDistBetweenNodes(12, 14));
	}
	
	@Test
	public void findSumOfAllAtLevelTest() {
		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		
		Assert.assertEquals(-1, tree.findSumOfAllAtLevel(0), 0.0);
		Assert.assertEquals(10, tree.findSumOfAllAtLevel(1), 0.0);
		Assert.assertEquals(15, tree.findSumOfAllAtLevel(2), 0.0);
		Assert.assertEquals(21, tree.findSumOfAllAtLevel(3), 0.0);
		Assert.assertEquals(0, tree.findSumOfAllAtLevel(4), 0.0);
		Assert.assertEquals(0, tree.findSumOfAllAtLevel(5), 0.0);
	}
}
