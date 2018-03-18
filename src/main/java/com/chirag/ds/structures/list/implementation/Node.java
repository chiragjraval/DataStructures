package com.chirag.ds.structures.list.implementation;

import com.chirag.ds.model.BaseNode;

/**
 * This class represents model node for Single direction list
 * @param <T> Type of object contained by Node
 * @author Chirag 
 */
class Node<T> extends BaseNode<T> {

	private Node<T> next;
	
	/**
	 * Default Constructor
	 * @param data Data object for Node
	 */
	protected Node() {
		super();
		this.data = null;
		this.next = null;
	}
	
	/**
	 * Constructor with null next node
	 * @param data Data object for Node
	 */
	protected Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}
	
	/**
	 * Constructor with all fields
	 * @param data Data object for Node
	 * @param next Pointer to next Node
	 */
	protected Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
}
