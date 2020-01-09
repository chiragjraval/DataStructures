package com.chirag.ds.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chirag.ds.graph.Graph;
import com.chirag.ds.graph.GraphNode;

public class UndirectedGraph<E> implements Graph<E> {

	protected Set<GraphNode<E>> nodes;
	protected Map<GraphNode<E>, List<GraphNode<E>>> adjacencyList;
	
	public UndirectedGraph() {
		nodes = new HashSet<GraphNode<E>>();
		adjacencyList = new HashMap<GraphNode<E>, List<GraphNode<E>>>();
	}
	
	@Override
	public Graph<E> addNode(GraphNode<E> node) {
		if(!nodes.contains(node)) {
			nodes.add(node);
			adjacencyList.put(node, new ArrayList<GraphNode<E>>());
		}
		return this;
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
		adjacencyList.get(destination).add(source);
		return this;
	}

	@Override
	public Set<GraphNode<E>> getNodes() {
		return nodes;
	}

	@Override
	public List<GraphNode<E>> getAdjacentNodes(GraphNode<E> node) {
		return adjacencyList.get(node);
	}

}
