package com.chirag.ds.queue;

import org.junit.Assert;
import org.junit.Test;

import com.chirag.ds.exceptions.QueueEmptyException;
import com.chirag.ds.exceptions.QueueFullException;
import com.chirag.ds.queue.Queue;

public class QueueTest {
	
	@Test
	public void addRemoveTest() {
		Queue<Integer> intQueue = new Queue<Integer>(3);
		intQueue.add(1);
		intQueue.add(2);
		intQueue.add(3);
		Assert.assertEquals(Integer.valueOf(1), intQueue.remove());
		Assert.assertEquals(Integer.valueOf(2), intQueue.remove());
		Assert.assertEquals(Integer.valueOf(3), intQueue.remove());
	}

	@Test(expected = QueueFullException.class)
	public void queueFullExceptionTest() {
		Queue<Integer> intQueue = new Queue<Integer>(2);
		intQueue.add(1);
		intQueue.add(2);
		intQueue.add(3);
	}
	
	@Test(expected = QueueEmptyException.class)
	public void queueEmptyExceptionTest() {
		Queue<Integer> intQueue = new Queue<Integer>(1);
		intQueue.add(1);
		intQueue.remove();
		intQueue.remove();
	}
}
