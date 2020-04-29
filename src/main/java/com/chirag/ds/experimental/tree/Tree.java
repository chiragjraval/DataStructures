package com.chirag.ds.experimental.tree;

import java.util.List;

public interface Tree<T> {

	T getRoot();
	
	List<T> getChildren(T node);
	
}
