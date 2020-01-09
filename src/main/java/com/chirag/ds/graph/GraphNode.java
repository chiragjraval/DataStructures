package com.chirag.ds.graph;

import com.chirag.ds.model.BaseNode;

public class GraphNode<E> extends BaseNode<E> {

	public GraphNode(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
