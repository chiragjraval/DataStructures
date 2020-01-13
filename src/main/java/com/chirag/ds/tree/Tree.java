package com.chirag.ds.tree;

import java.util.Optional;

public interface Tree<T> {
	
	Optional<T> getRoot();
	int getHeight();
	
}