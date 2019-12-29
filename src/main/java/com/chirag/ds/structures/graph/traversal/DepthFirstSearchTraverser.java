package com.chirag.ds.structures.graph.traversal;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.chirag.ds.model.BaseNode;
import com.chirag.ds.structures.array.Stack;
import com.chirag.ds.structures.graph.Graph;
import com.chirag.ds.structures.graph.GraphNode;

public class DepthFirstSearchTraverser<E> implements GraphTraverser<E> {

	private Graph<E> graph;
	private GraphNode<E> source;
	private Stack<GraphNode<E>> processingStack;
	private Map<GraphNode<E>, Boolean> visitedNodes;

	public DepthFirstSearchTraverser(Graph<E> graph, GraphNode<E> source) {
		this.graph = graph;
		this.source = source;
		this.visitedNodes = new ConcurrentHashMap<>();
		this.graph.getNodes().stream().forEach(node -> this.visitedNodes.put(node, false));
		this.processingStack = new Stack<>(graph.getNodes().size());
		this.processingStack.push(source);
	}

	public BaseNode<E> getSource() {
		return source;
	}

	public boolean hasNext() {
		return !processingStack.isEmpty();
	}

	public GraphNode<E> next() {
		GraphNode<E> result = null;
		if (hasNext()) {
			result = processingStack.peek();
			visitedNodes.put(result, true);

			while (hasNext() && !getUnvisitedAdjacentNodeOptional(processingStack.peek()).isPresent()) {
				processingStack.pop();
			}

			if (hasNext()) {
				Optional<GraphNode<E>> adjacentNode = getUnvisitedAdjacentNodeOptional(processingStack.peek());
				processingStack.push(adjacentNode.get());
			}
		}
		return result;
	}

	private Optional<GraphNode<E>> getUnvisitedAdjacentNodeOptional(GraphNode<E> source) {
		if (Objects.nonNull(source)) {
			return graph.getAdjacentNodes(source).stream().filter(node -> !visitedNodes.get(node)).findFirst();
		} else {
			return Optional.empty();
		}
	}
}
