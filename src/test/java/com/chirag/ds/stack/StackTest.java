package com.chirag.ds.stack;

import org.junit.Assert;
import org.junit.Test;

import com.chirag.ds.exceptions.StackEmptyException;
import com.chirag.ds.exceptions.StackFullException;
import com.chirag.ds.stack.Stack;

public class StackTest {

	@Test
	public void peekPushPopTest() {
		Stack<Integer> intStack = new Stack<Integer>(3);
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		Assert.assertEquals(Integer.valueOf(3), intStack.peek());
		Assert.assertEquals(Integer.valueOf(3), intStack.pop());
		Assert.assertEquals(Integer.valueOf(2), intStack.pop());
		Assert.assertEquals(Integer.valueOf(1), intStack.pop());
	}
	
	@Test(expected = StackFullException.class)
	public void stackFullExceptionTest() {
		Stack<Integer> intStack = new Stack<Integer>(2);
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
	}
	
	@Test(expected = StackEmptyException.class)
	public void stackEmptyExceptionTest() {
		Stack<Integer> intStack = new Stack<Integer>(2);
		intStack.push(1);
		intStack.pop();
		intStack.pop();
	}
}
