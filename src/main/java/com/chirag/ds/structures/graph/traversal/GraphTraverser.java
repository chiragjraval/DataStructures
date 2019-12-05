package com.chirag.ds.structures.graph.traversal;

import com.chirag.ds.structures.graph.GraphNode;

public interface GraphTraverser<E> {

	boolean hasNext();
	
	GraphNode<E> next();
	
}
