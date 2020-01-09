package com.chirag.ds.tree.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.chirag.ds.util.ListUtil;

public class BinaryTree<T> extends AbstractTree<T> {

	public BinaryTree() {
		super();
	}
	
	@Override
	public Optional<T> insert(T value) {
		TreeNode<T> newNode = new TreeNode<T>(value);
		TreeNode<T> parent = null;
		EdgeType parentNodeEdge = null;
		
		boolean parentFound = false;
		List<TreeNode<T>> nodeList = ListUtil.getNonNullList(this.root); 
		while (!parentFound && !nodeList.isEmpty()) {
			List<TreeNode<T>> nextLevelNodeList = new ArrayList<>();
			for (TreeNode<T> node : nodeList) {
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
		Optional<TreeNode<T>> nodeOptional = findNode(value);
		if(nodeOptional.isPresent()) {
			TreeNode<T> node = nodeOptional.get();
			Optional<TreeNode<T>> leafOptional = findAnyLeafNode(node);
			if(leafOptional.isPresent()) {
				TreeNode<T> leaf = leafOptional.get();
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

}
