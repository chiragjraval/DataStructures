package com.chirag.ds.structures.heap;

import java.util.Optional;

public interface Heap<T> {

	Optional<T> take();
	void put(T value);
	
}
