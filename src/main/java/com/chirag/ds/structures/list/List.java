package com.chirag.ds.structures.list;

import java.util.Optional;

public interface List<T> {

	boolean contains(T value);
	Optional<T> add(T value);
	Optional<T> remove(T value);
	
}
