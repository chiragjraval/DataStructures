package com.chirag.ds.graph;

import java.util.List;
import java.util.Set;

public interface Graph<E> {

	Set<GraphNode<E>> getNodes();
	
	List<GraphNode<E>> getAdjacentNodes(GraphNode<E> node);
	
	Graph<E> addNode(GraphNode<E> node);
	
	Graph<E> addEdge(GraphNode<E> source, GraphNode<E> destination);
	
}
