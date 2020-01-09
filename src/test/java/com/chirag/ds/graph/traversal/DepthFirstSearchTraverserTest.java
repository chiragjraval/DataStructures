package com.chirag.ds.structures.graph.traversal;

import org.junit.Assert;
import org.junit.Test;

import com.chirag.ds.structures.graph.Graph;
import com.chirag.ds.structures.graph.GraphNode;
import com.chirag.ds.structures.graph.impl.DirectedGraph;
import com.chirag.ds.structures.graph.impl.UndirectedGraph;

public class DepthFirstSearchTraverserTest {

	@Test
	public void testTraversalForUndirectedGraph() {
		GraphNode<Integer> node0 = new GraphNode<Integer>(0);
		GraphNode<Integer> node1 = new GraphNode<Integer>(1);
		GraphNode<Integer> node2 = new GraphNode<Integer>(2);
		GraphNode<Integer> node3 = new GraphNode<Integer>(3);
		
		Graph<Integer> graph = new UndirectedGraph<Integer>();
		graph.addEdge(node2, node0);
		graph.addEdge(node2, node1);
		graph.addEdge(node0, node1);
		graph.addEdge(node2, node3);
		graph.addEdge(node3, node3);
		
		DepthFirstSearchTraverser<Integer> traverser = new DepthFirstSearchTraverser<>(graph, node2);
		Assert.assertEquals(node2, traverser.next());
		Assert.assertEquals(node0, traverser.next());
		Assert.assertEquals(node1, traverser.next());
		Assert.assertEquals(node3, traverser.next());
		Assert.assertEquals(false, traverser.hasNext());
		Assert.assertEquals(null, traverser.next());
	}
	
	@Test
	public void testTraversalForDirectedGraph() {
		GraphNode<Integer> node0 = new GraphNode<Integer>(0);
		GraphNode<Integer> node1 = new GraphNode<Integer>(1);
		GraphNode<Integer> node2 = new GraphNode<Integer>(2);
		GraphNode<Integer> node3 = new GraphNode<Integer>(3);
		
		Graph<Integer> graph = new DirectedGraph<Integer>();
		graph.addEdge(node2, node0);
		graph.addEdge(node0, node2);
		graph.addEdge(node0, node1);
		graph.addEdge(node1, node2);
		graph.addEdge(node2, node3);
		graph.addEdge(node3, node3);
		
		DepthFirstSearchTraverser<Integer> traverser = new DepthFirstSearchTraverser<>(graph, node2);
		Assert.assertEquals(node2, traverser.next());
		Assert.assertEquals(node0, traverser.next());
		Assert.assertEquals(node1, traverser.next());
		Assert.assertEquals(node3, traverser.next());
		Assert.assertEquals(false, traverser.hasNext());
		Assert.assertEquals(null, traverser.next());
	}

}
