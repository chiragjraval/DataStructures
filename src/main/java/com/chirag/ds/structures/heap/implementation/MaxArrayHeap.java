package com.chirag.ds.structures.heap.implementation;

import java.util.Collection;
import java.util.Objects;

public class MaxArrayHeap<T extends Comparable<T>> extends AbstractArrayHeap<T> {

	public MaxArrayHeap() {
		super();
	}
	
	public MaxArrayHeap(T[] values) {
		super(values);
	}
	
	public MaxArrayHeap(Collection<T> values) {
		super(values);
	}
	
	@Override
	protected boolean swapRequired(T parent, T child) {
		if(Objects.isNull(parent) || Objects.isNull(child)) {
			return false;
		}
		else if(parent.compareTo(child) < 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
