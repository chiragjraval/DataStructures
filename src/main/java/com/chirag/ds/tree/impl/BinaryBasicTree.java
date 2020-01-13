package com.chirag.ds.tree.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.chirag.ds.util.ListUtil;

public class BinaryBasicTree<T> extends AbstractBinaryTree<T> {

	public BinaryBasicTree() {
		super();
	}
	
	@Override
	public Optional<T> insert(T value) {
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value);
		BinaryTreeNode<T> parent = null;
		EdgeType parentNodeEdge = null;
		
		boolean parentFound = false;
		List<BinaryTreeNode<T>> nodeList = ListUtil.getNonNullList(this.root); 
		while (!parentFound && !nodeList.isEmpty()) {
			List<BinaryTreeNode<T>> nextLevelNodeList = new ArrayList<>();
			for (BinaryTreeNode<T> node : nodeList) {
				if(Objects.isNull(node.getLeft())) {
					parent = node;
					parentNodeEdge = EdgeType.LEFT;
					parentFound = true;
					break;
				}
				else if(Objects.isNull(node.getRight())) {
					parent = node;
					parentNodeEdge = EdgeType.RIGHT;
					parentFound = true;
					break;
				}
				else {
					ListUtil.addNonNullToList(nextLevelNodeList, node.getLeft(), node.getRight());
				}
			}
			nodeList = nextLevelNodeList;
		}
		
		if(Objects.isNull(parent))
			this.root = newNode;
		else
			setChild(parent, newNode, parentNodeEdge);
		
		return Optional.of(newNode.getData());
	}

	@Override
	public Optional<T> delete(T value) {
		Optional<BinaryTreeNode<T>> nodeOptional = findNode(value);
		if(nodeOptional.isPresent()) {
			BinaryTreeNode<T> node = nodeOptional.get();
			Optional<BinaryTreeNode<T>> leafOptional = findAnyLeafNode(node);
			if(leafOptional.isPresent()) {
				BinaryTreeNode<T> leaf = leafOptional.get();
				node.setData(leaf.getData());
				setEdgeNull(leaf.getParent(), leaf.getParentNodeEdge());
				leaf.free();
			}
			else {
				node.free();
			}
			return Optional.of(value);
		}
		return Optional.empty();
	}

	@Override
	public int getHeight() {
		return 0;
	}

}
