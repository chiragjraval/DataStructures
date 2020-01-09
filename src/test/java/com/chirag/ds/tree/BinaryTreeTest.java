package com.chirag.ds.tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import com.chirag.ds.tree.Tree;
import com.chirag.ds.tree.impl.BinaryTree;

public class BinaryTreeTest {

	private List<Integer> sortedList(List<Integer> origList) {
		return origList.stream().sorted().collect(Collectors.toList());
	}
	
	@Test
	public void insertTest() { 
		Tree<Integer> tree = new BinaryTree<Integer>();
		List<Integer> inOrderList;
		
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(sortedList(inOrderList).equals(Arrays.asList(3, 10, 12)));
		
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(sortedList(inOrderList).equals(Arrays.asList(2, 3, 5, 10, 12, 14)));
	}
	
	@Test
	public void deleteTest() {
		Tree<Integer> tree = new BinaryTree<Integer>();
		List<Integer> inOrderList;
		
		tree.insert(10);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		tree.insert(5);
		tree.insert(14);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(sortedList(inOrderList).equals(Arrays.asList(2, 3, 5, 10, 12, 14)));
		
		tree.delete(14);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(sortedList(inOrderList).equals(Arrays.asList(2, 3, 5, 10, 12)));
		
		tree.delete(10);
		inOrderList = tree.inOrderList();
		Assert.assertTrue(sortedList(inOrderList).equals(Arrays.asList(2, 3, 5, 12)));
	}
	
}
