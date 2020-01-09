package com.chirag.ds.heap.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.chirag.ds.heap.Heap;

abstract class AbstractArrayHeap<T extends Comparable<T>> implements Heap<T> {

	abstract protected boolean swapRequired(T parent, T child);
	
	private List<T> values;
	
	public AbstractArrayHeap() {
		super();
		this.values = new ArrayList<>();
	}
	
	public AbstractArrayHeap(T[] values) {
		super();
		this.values = new ArrayList<>(values.length);
		init(Arrays.asList(values));
	}
	
	public AbstractArrayHeap(Collection<T> values) {
		super();
		this.values = new ArrayList<>(values.size());
		init(values);
	}
	
	@Override
	public synchronized Optional<T> take() {
		if(!values.isEmpty()) {
			Optional<T> result = Optional.of(values.get(0));
			swap(0, size()-1);
			values.remove(size()-1);
			heapifyDown(0);
			return result;
		}
		return Optional.empty();
	}
	
	@Override
	public synchronized void put(T value) {
		values.add(value);
		heapifyUp(size()-1); 
	}
	
	private void init(Collection<T> values) {
		if(Objects.nonNull(values)) {
			for (T value : values) {
				put(value);
			}
		}
	}
	
	private int size() {
		return values.size();
	}
	
	private void swap(int idx1, int idx2) {
		T temp = values.get(idx1);
		values.set(idx1, values.get(idx2));
		values.set(idx2, temp);
	}
	
	private void heapifyUp(int idx) {
		if(idx<=0)
			return;
		
		int parentIdx = (idx-1)>>1;
		if(swapRequired(values.get(parentIdx), values.get(idx))) {
			swap(idx, parentIdx);
			heapifyUp(parentIdx);
		}
	}
	
	private void heapifyDown(int idx) {
		int rootIdx = idx;
		int leftChildIdx = (idx<<1) + 1;
		int rightChildIdx = (idx<<1) + 2;
		
		if(leftChildIdx<size() && swapRequired(values.get(idx), values.get(leftChildIdx))) {
			idx = leftChildIdx;
		}
		if(rightChildIdx<size() && swapRequired(values.get(idx), values.get(rightChildIdx))) {
			idx = rightChildIdx;
		}
		
		if(rootIdx!=idx) {
			swap(rootIdx, idx);
			heapifyDown(idx);
		}
	}
}
