package com.chirag.ds.structures.list;

import org.junit.Assert;
import org.junit.Test;

import com.chirag.ds.structures.list.implementation.LinkedList;

public class LinkedListTest {
	@Test
	public void basicOperationTest() {
		List<Integer> intList = new LinkedList<Integer>(4);
		Assert.assertTrue(intList.contains(4));
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Assert.assertTrue(intList.contains(2));
		intList.remove(1);
		Assert.assertFalse(intList.contains(1));
	}
}
