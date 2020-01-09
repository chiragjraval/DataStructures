package com.chirag.ds.structures.heap;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.chirag.ds.structures.heap.implementation.MaxArrayHeap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaxArrayHeapTest {

	private Heap<Integer> heap;
	
	@Before
	public void setUp() {
		heap = new MaxArrayHeap<Integer>();
	}
	
	@Test
	public void testEmptyTake() {
		Assert.assertFalse(heap.take().isPresent());
	}
	
	@Test
	public void testDefaultArrayInit() {
		Integer[] values = {5, 3, 7, 2};
		heap = new MaxArrayHeap<Integer>(values);
		Assert.assertTrue(heap.take().get().equals(7));
		Assert.assertTrue(heap.take().get().equals(5));
		Assert.assertTrue(heap.take().get().equals(3));
		Assert.assertTrue(heap.take().get().equals(2));
		Assert.assertFalse(heap.take().isPresent());
	}
	
	@Test
	public void testDefaultCollectionInit() {
		List<Integer> values = Arrays.asList(5, 3, 7, 2);
		heap = new MaxArrayHeap<Integer>(values);
		Assert.assertTrue(heap.take().get().equals(7));
		Assert.assertTrue(heap.take().get().equals(5));
		Assert.assertTrue(heap.take().get().equals(3));
		Assert.assertTrue(heap.take().get().equals(2));
		Assert.assertFalse(heap.take().isPresent());
	}
	
	@Test
	public void testSortedData() {
		heap.put(5);
		heap.put(3);
		heap.put(7);
		heap.put(2);
		Assert.assertTrue(heap.take().get().equals(7));
		Assert.assertTrue(heap.take().get().equals(5));
		Assert.assertTrue(heap.take().get().equals(3));
		Assert.assertTrue(heap.take().get().equals(2));
		Assert.assertFalse(heap.take().isPresent());
	}
}
