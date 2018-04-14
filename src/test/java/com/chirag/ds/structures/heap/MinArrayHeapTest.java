package com.chirag.ds.structures.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.chirag.ds.structures.heap.implementation.MinArrayHeap;

public class MinArrayHeapTest {

	private Heap<Integer> heap;
	
	@Before
	public void setUp() {
		heap = new MinArrayHeap<Integer>();
	}
	
	@Test
	public void testEmptyTake() {
		Assert.assertFalse(heap.take().isPresent());
	}
	
	@Test
	public void testDefaultArrayInit() {
		Integer[] values = {5, 3, 7, 2};
		heap = new MinArrayHeap<Integer>(values);
		Assert.assertTrue(heap.take().get().equals(2));
		Assert.assertTrue(heap.take().get().equals(3));
		Assert.assertTrue(heap.take().get().equals(5));
		Assert.assertTrue(heap.take().get().equals(7));
		Assert.assertFalse(heap.take().isPresent());
	}
	
	@Test
	public void testDefaultCollectionInit() {
		Integer[] values = {5, 3, 7, 2};
		heap = new MinArrayHeap<Integer>(values);
		Assert.assertTrue(heap.take().get().equals(2));
		Assert.assertTrue(heap.take().get().equals(3));
		Assert.assertTrue(heap.take().get().equals(5));
		Assert.assertTrue(heap.take().get().equals(7));
		Assert.assertFalse(heap.take().isPresent());
	}
	
	@Test
	public void testSortedData() {
		heap.put(5);
		heap.put(3);
		heap.put(7);
		heap.put(2);
		Assert.assertTrue(heap.take().get().equals(2));
		Assert.assertTrue(heap.take().get().equals(3));
		Assert.assertTrue(heap.take().get().equals(5));
		Assert.assertTrue(heap.take().get().equals(7));
		Assert.assertFalse(heap.take().isPresent());
	}
}
