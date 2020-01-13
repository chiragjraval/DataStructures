package com.chirag.ds.tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import com.chirag.ds.tree.impl.BinaryBasicTree;

public class BinaryBasicTreeTest {

	private List<Integer> sortedList(List<Integer> origList) {
		return origList.stream().sorted().collect(Collectors.toList());
	}
	
	@Test
	public void insertTest() { 
		BinaryTree<Integer> tree = new BinaryBasicTree<Integer>();
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
		BinaryTree<Integer> tree = new BinaryBasicTree<Integer>();
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
