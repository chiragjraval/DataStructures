package com.chirag.ds.array;

import java.util.Arrays;

import com.chirag.ds.exceptions.StackEmptyException;
import com.chirag.ds.exceptions.StackFullException;

/**
 * This class represents Stack Data Structure.
 * 
 * @param <T>
 *            Type of Data object
 */
public class Stack<T> {

	private T[] arrayStack;
	private int top = 0;
	private int stackDepth;

	@SuppressWarnings("unchecked")
	public Stack(int stackDepth) {
		super();
		this.arrayStack = (T[]) new Object[stackDepth];
		this.top = 0;
		this.stackDepth = stackDepth;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public T peek() {
		T result = null;
		if (!isEmpty())
			result = arrayStack[top - 1];
		return result;
	}

	public void push(T obj) throws StackFullException {
		if (top == stackDepth) {
			throw new StackFullException();
		} else {
			arrayStack[top] = obj;
			top++;
		}
	}

	public T pop() throws StackEmptyException {
		T obj = null;

		if (top == 0) {
			throw new StackEmptyException();
		} else {
			top--;
			obj = (T) arrayStack[top];
			arrayStack[top] = null;
		}

		return obj;
	}

	@Override
	public String toString() {
		return "Stack [arrayStack=" + Arrays.toString(arrayStack) + ", top=" + top + ", stackDepth=" + stackDepth + "]";
	}
}
