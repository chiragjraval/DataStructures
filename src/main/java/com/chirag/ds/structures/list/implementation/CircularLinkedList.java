package com.chirag.ds.structures.list.implementation;

import java.util.Optional;

import com.chirag.ds.comparison.ComparisonHelper;
import com.chirag.ds.comparison.ComparisonType;
import com.chirag.ds.structures.list.List;

/**
 * This class represents CircularLinkedList Data Structure.
 * @param <T> Type of Data object
 * @author Chirag
 */
public class CircularLinkedList<T> implements List<T> {

	private TwoWayNode<T> head;
	
	
	/**
	 * This method initializes a CircularLinkedList with null Header 
	 */
	public CircularLinkedList() {
		this.head = null; 
	}
	
	/**
	 * This method initializes a CircularLinkedList with Header containing passed object 
	 * @param obj Initial header object
	 */
	public CircularLinkedList(T obj) {
		add(obj);
	}
	
	/**
	 * @param obj Data obj to be added as Node
	 * @return true/false status for add operation 
	 */
	@Override
	public Optional<T> add(T obj)
	{
		TwoWayNode<T> node = new TwoWayNode<T>(obj);
		return Optional.ofNullable(add(node));
	}
	
	/**
	 * @param node Object to be added as Node
	 * @return true/false status for add operation 
	 */
	private T add(TwoWayNode<T> node)
	{	
		if(head==null)
		{
			head = node;
			head.setNext(head);
			head.setPrev(head);
			return node.getData();
		}
		else
		{
			TwoWayNode<T> temp = head;
			while(temp.getNext()!=head) temp = temp.getNext();
			
			node.setPrev(temp);
			node.setNext(head);
			head.setPrev(node);
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
		TwoWayNode<T> node = new TwoWayNode<T>(obj);
		return Optional.ofNullable(remove(node, ComparisonType.DATA));
	}
	
	/**
	 * This method is used to remove node from list
	 * @param node Object to be removed from list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for remove operation
	 */
	private T remove(TwoWayNode<T> node, ComparisonType comType)
	{
		if(head==null)
			return null;
		else if(ComparisonHelper.compare(head, node, comType))
		{
			if(head.getNext()==head && head.getPrev()==head)
				head = null;
			else
			{
				head.getNext().setPrev(head.getPrev());
				head.getPrev().setNext(head.getNext());
				head = head.getNext();
			}

			return node.getData();
		}
		else
		{
			TwoWayNode<T> temp = head;
			while(temp.getNext()!= null)
			{
				if(ComparisonHelper.compare(temp.getNext(), node, comType))
				{
					TwoWayNode<T> foundNode = temp.getNext();
					temp.setNext(foundNode.getNext());
					foundNode.getNext().setPrev(temp);
					return node.getData();
				}
				else
					temp = temp.getNext();
			}
			
			return null;
		}
	}
	
	
	/**
	 * This method is used to verify that list contains Node with passed data obj 
	 * @param obj Data obj to be removed from list
	 * @return true/false status for existence status 
	 */
	@Override
	public boolean contains(T obj)
	{
		TwoWayNode<T> node = new TwoWayNode<T>(obj);
		return contains(node, ComparisonType.DATA);
	}
	
	/**
	 * This method is used to verify that list contains passed Node
	 * @param node Node to be verify against list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for existence status
	 */
	private boolean contains(TwoWayNode<T> node, ComparisonType comType)
	{
		if(head==null)
			return false;
		else
		{
			if(ComparisonHelper.compare(head, node, comType))
				return true;
			
			TwoWayNode<T> temp = head.getNext();
			while(temp!=head)
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
