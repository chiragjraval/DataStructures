package com.chirag.ds.structures.graph.traversal;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.chirag.ds.model.BaseNode;
import com.chirag.ds.structures.graph.Graph;
import com.chirag.ds.structures.graph.GraphNode;

public class BreadthFirstSearchTraverser<E> implements GraphTraverser<E> {

	private Graph<E> graph;
	private GraphNode<E> source;
	private Queue<GraphNode<E>> processingQueue;
	private Map<GraphNode<E>, Boolean> visitedNodes;

	public BreadthFirstSearchTraverser(Graph<E> graph, GraphNode<E> source) {
		this.graph = graph;
		this.source = source;
		this.visitedNodes = new ConcurrentHashMap<>();
		this.graph.getNodes().stream().forEach(node -> this.visitedNodes.put(node, false));
		this.processingQueue = new ConcurrentLinkedQueue<>();
		this.processingQueue.add(source);
	}

	public BaseNode<E> getSource() {
		return source;
	}

	public boolean hasNext() {
		while (!processingQueue.isEmpty() && visitedNodes.get(processingQueue.peek())) {
			processingQueue.remove();
		}
		return !processingQueue.isEmpty();
	}

	public GraphNode<E> next() {
		if (!hasNext()) {
			return null;
		} else {
			GraphNode<E> nextNode = processingQueue.remove();
			visitedNodes.put(nextNode, true);
			graph.getAdjacentNodes(nextNode).stream().filter(adjacentNode -> !visitedNodes.get(adjacentNode))
					.forEach(adjacentNode -> processingQueue.add(adjacentNode));
			return nextNode;
		}
	}

}
