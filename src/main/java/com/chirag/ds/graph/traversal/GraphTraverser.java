package com.chirag.ds.graph.traversal;

import com.chirag.ds.graph.GraphNode;

public interface GraphTraverser<E> {

	boolean hasNext();
	
	GraphNode<E> next();
	
}
