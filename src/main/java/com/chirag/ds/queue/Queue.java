/**
 * 
 */
package com.chirag.ds.queue;

import java.util.Arrays;

import com.chirag.ds.exceptions.QueueEmptyException;
import com.chirag.ds.exceptions.QueueFullException;

/**
 * This class represents Queue Data Structure.
 * 
 * @param <T>
 *            Type of Data object
 * @author Chirag
 */
public class Queue<T> {

	private T[] arrayQueue;
	private int front, rear;
	private int queueSize;

	/**
	 * @param queueSize
	 */
	@SuppressWarnings("unchecked")
	public Queue(int queueSize) {
		super();
		this.arrayQueue = (T[]) new Object[queueSize];
		this.front = -1;
		this.rear = -1;
		this.queueSize = queueSize;
	}

	/**
	 * @param obj
	 *            Data obj to be added to Queue
	 */
	public void add(T obj) throws QueueFullException {
		if (front == rear && front != -1 && rear != -1) {
			throw new QueueFullException();
		} else {
			if (front == -1 && rear == -1)
				front = rear = 0;
			arrayQueue[front] = obj;
			front = (front + 1) % queueSize;
		}
	}

	/**
	 * @return Data obj in Queue
	 */
	public T remove() throws QueueEmptyException {
		T obj = null;
		
		if (rear == front && front == -1 && rear == -1) {
			throw new QueueEmptyException();
		} else {
			obj = (T) arrayQueue[rear];
			arrayQueue[rear] = null;
			rear = (rear + 1) % queueSize;
			if (rear == front)
				rear = front = -1;
		}
		return obj;
	}

	@Override
	public String toString() {
		return "Queue [arrayQueue=" + Arrays.toString(arrayQueue) + ", front=" + front + ", rear=" + rear
				+ ", queueSize=" + queueSize + "]";
	}
}
