package com.chirag.ds.structures.graph.impl;

import com.chirag.ds.structures.graph.Graph;
import com.chirag.ds.structures.graph.GraphNode;

public class DirectedGraph<E> extends UndirectedGraph<E> {

	public DirectedGraph() {
		super();
	}
	
	@Override
	public Graph<E> addEdge(GraphNode<E> source, GraphNode<E> destination) {
		if(!nodes.contains(source)) {
			addNode(source);
		}
		if(!nodes.contains(destination)) {
			addNode(destination);
		}
		adjacencyList.get(source).add(destination);
		return this;
	}

}
