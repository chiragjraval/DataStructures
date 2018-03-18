package com.chirag.ds.structures.list.implementation;

import java.util.Optional;

import com.chirag.ds.comparison.ComparisonHelper;
import com.chirag.ds.comparison.ComparisonType;
import com.chirag.ds.structures.list.List;

/**
 * This class represents LinkedList Data Structure.
 * @param <T> Type of Data object
 * @author Chirag
 */
public class LinkedList<T> implements List<T> {

	private Node<T> head;
	
	
	/**
	 * This method initializes a LinkedList with null Header 
	 */
	public LinkedList() {
		this.head = null; 
	}
	
	/**
	 * This method initializes a LinkedList with Header containing passed object 
	 * @param obj Initial header object
	 */
	public LinkedList(T obj) {
		add(obj);
	}
	
	/**
	 * @param obj Data obj to be added as Node
	 * @return true/false status for add operation 
	 */
	@Override
	public Optional<T> add(T obj)
	{
		Node<T> node = new Node<T>(obj);
		return Optional.of(add(node));
	}
	
	/**
	 * @param node Object to be added as Node
	 * @return true/false status for add operation 
	 */
	private T add(Node<T> node)
	{	
		if(head==null)
		{
			head = node;
			return node.getData();
		}
		else
		{
			Node<T> temp = head;
			while(temp.getNext()!=null) temp = temp.getNext();
			temp.setNext(node);
			return node.getData();
		}
	}
	
	/**
	 * This method is used to remove first node that matches passed data object 
	 * @param obj Data obj to be removed from list
	 * @return true/false status for remove operation 
	 */
	@Override
	public Optional<T> remove(T obj)
	{
		Node<T> node = new Node<T>(obj);
		return Optional.ofNullable(remove(node, ComparisonType.DATA));
	}
	
	/**
	 * This method is used to remove node from list
	 * @param node Object to be removed from list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for remove operation
	 */
	private T remove(Node<T> node, ComparisonType comType)
	{
		if(head==null)
			return null;
		else if(ComparisonHelper.compare(head, node, comType))
		{
			head = head.getNext();
			return node.getData();
		}
		else
		{
			Node<T> temp = head;
			while(temp.getNext()!= null)
			{
				if(ComparisonHelper.compare(temp.getNext(), node, comType))
				{
					temp.setNext(temp.getNext().getNext());
					return node.getData();
				}
				else
					temp = temp.getNext();
			}
		}
		
		return null;
	}
	
	
	/**
	 * This method is used to verify that list contains Node with passed data obj 
	 * @param obj Data obj to be removed from list
	 * @return true/false status for existence status 
	 */
	@Override
	public boolean contains(T obj)
	{
		Node<T> node = new Node<T>(obj);
		return contains(node, ComparisonType.DATA);
	}
	
	/**
	 * This method is used to verify that list contains passed Node
	 * @param node Node to be verify against list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for existence status
	 */
	private boolean contains(Node<T> node, ComparisonType comType)
	{
		if(head==null)
			return false;
		else
		{
			Node<T> temp = head;
			while(temp!=null)
			{
				if(ComparisonHelper.compare(temp, node, comType))
					return true;
				else
					temp = temp.getNext();
			}
		}
		
		return false;
	}
}
