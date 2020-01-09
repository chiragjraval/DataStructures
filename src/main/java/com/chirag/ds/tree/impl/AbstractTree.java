package com.chirag.ds.tree.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Optional;

import com.chirag.ds.tree.Tree;
import com.chirag.ds.util.ListUtil;

abstract class AbstractTree<T> implements Tree<T> {

	protected TreeNode<T> root;
	
	public TreeNode<T> getRoot() {
		return this.root;
	}
	
	class BooleanRef
	{
		public boolean value;
		
		public BooleanRef(boolean value)
		{
			this.value = value;
		}
	}
	
	class IntegerRef
	{
		public int value;
		
		public IntegerRef(int value)
		{
			this.value = value;
		}
	}
	
	protected void setEdgeNull(TreeNode<T> node, EdgeType edgeType) {
		if(EdgeType.LEFT.equals(edgeType))
			node.setLeft(null);
		else if(EdgeType.RIGHT.equals(edgeType))
			node.setRight(null);
	}
	
	protected void setChild(TreeNode<T> node, TreeNode<T> child, EdgeType edgeType) {
		if(EdgeType.LEFT.equals(edgeType))
			node.setLeft(child);
		else if(EdgeType.RIGHT.equals(edgeType))
			node.setRight(child);
		
		child.setParent(node);
		child.setParentNodeEdge(edgeType);
	}
	
	protected int findLevel(TreeNode<T> root, TreeNode<T> node, int level)
	{
		if(root==null)
			return -1;
		
		if(root.equals(node))
			return level;
		
		int d = findLevel(root.getLeft(), node, level+1);
		return d!=-1 ? d : findLevel(root.getRight(), node, level+1);
	}
	
	protected Optional<TreeNode<T>> findNode(T value) {
		if(Objects.nonNull(value) && Objects.nonNull(this.root)) {
			ListIterator<TreeNode<T>> queueIterator = ListUtil.getListIterator(this.root);
			while (queueIterator.hasNext()) {
				TreeNode<T> temp = queueIterator.next();
				if(temp.getData().equals(value))
					return Optional.of(temp);
				ListUtil.addNonNullToListIterator(queueIterator, temp.getLeft(), temp.getRight());
			}
		}
		return Optional.empty();
	}
	
	protected Optional<TreeNode<T>> findAnyLeafNode(TreeNode<T> node) {
		if(Objects.nonNull(node)) {
			ListIterator<TreeNode<T>> queueIterator = ListUtil.getListIterator(node);
			while (queueIterator.hasNext()) {
				TreeNode<T> temp = queueIterator.next();
				if(Objects.isNull(temp.getLeft()) && Objects.isNull(temp.getRight()))
					return Optional.of(temp);
				ListUtil.addNonNullToListIterator(queueIterator, temp.getLeft(), temp.getRight());
			}
		}
		return Optional.empty();
	}
	
	protected boolean checkIfNodeExist(TreeNode<T> node, T data)
	{
		if(node==null)
			return false;
		
		if(node.getData().equals(data))
			return true;
		
		return checkIfNodeExist(node.getLeft(), data) || checkIfNodeExist(node.getRight(), data);
	}
	
	protected TreeNode<T> checkAndGetIfNodeExist(TreeNode<T> node, T data)
	{
		if(node==null)
			return null;
		
		if(node.getData().equals(data))
			return node;
		
		TreeNode<T> resultLeft = checkAndGetIfNodeExist(node.getLeft(), data);
		
		return Objects.nonNull(resultLeft) ? resultLeft : checkAndGetIfNodeExist(node.getRight(), data); 
	}
	
	@Override
	public List<T> inOrderList()
	{
		List<T> resultList = new ArrayList<T>();
		inOrderListUtil(root, resultList);
		return resultList;
	}
	
	private void inOrderListUtil(TreeNode<T> node, List<T> resultList)
	{
		if(node==null)
			return;
		
		inOrderListUtil(node.getLeft(), resultList);
		resultList.add(node.getData());
		inOrderListUtil(node.getRight(), resultList);
	}
	
	@Override
	public List<T> preOrderList()
	{
		List<T> resultList = new ArrayList<T>();
		preOrderListUtil(root, resultList);
		return resultList;
	}
	
	private void preOrderListUtil(TreeNode<T> node, List<T> resultList)
	{
		if(node==null)
			return;
		
		resultList.add(node.getData());
		preOrderListUtil(node.getLeft(), resultList);
		preOrderListUtil(node.getRight(), resultList);
	}
	
	@Override
	public List<T> postOrderList()
	{
		List<T> resultList = new ArrayList<T>();
		postOrderListUtil(root, resultList);
		return resultList;
	}
	
	private void postOrderListUtil(TreeNode<T> node, List<T> resultList)
	{
		if(node==null)
			return;
		
		postOrderListUtil(node.getLeft(), resultList);
		postOrderListUtil(node.getRight(), resultList);
		resultList.add(node.getData());
	}
	
	public boolean isBinarySearchTree()
	{
		TreeNode<T> prev=new TreeNode<T>();
		return isBinarySearchTreeInOrderUtil(this.root, prev);
	}
	
	@SuppressWarnings("unchecked")
	private boolean isBinarySearchTreeInOrderUtil(TreeNode<T> node, TreeNode<T> prev)
	{
		if(node==null)
			return true;
		
		if(node.getData() instanceof Comparable) {
			Comparable<T> data = (Comparable<T>) node.getData();
			
			if(!isBinarySearchTreeInOrderUtil(node.getLeft(), prev))
				return false;
			
			if(prev.getData()!=null && data.compareTo(prev.getData())<=0)
				return false;
			
			prev.setData(node.getData());
			
			return isBinarySearchTreeInOrderUtil(node.getRight(), prev);
		}
	
		return false;
	}
	
	@Override
	public Optional<T> findLca(T data1, T data2)
	{
		BooleanRef v1 = new BooleanRef(false);
		BooleanRef v2 = new BooleanRef(false);
		TreeNode<T> lca = findLCAUtil(this.root, data1, data2, v1, v2);
		
		if( (v1.value && v2.value) 
				|| (v1.value && checkIfNodeExist(lca, data2))
				|| (v2.value && checkIfNodeExist(lca, data1)))
			return Optional.of(lca.getData());
		
		return Optional.empty();
	}
	
	private TreeNode<T> findLCAUtil(TreeNode<T> node, T data1, T data2, BooleanRef v1, BooleanRef v2)
	{
		if(node==null)
			return null;
		
		if(node.getData().equals(data1)) {
			v1.value = true;
			return node;
		}
		else if(node.getData().equals(data2)) {
			v2.value = true;
			return node;
		}
		
		TreeNode<T> leftLca = findLCAUtil(node.getLeft(), data1, data2, v1, v2);
		TreeNode<T> rigttLca = findLCAUtil(node.getRight(), data1, data2, v1, v2);
		
		if(leftLca!=null && rigttLca!=null)
			return node;
		else
			return (leftLca!=null) ? leftLca : rigttLca;
	}
	
	@Override
	public int findShortestDistBetweenNodes(T data1, T data2)
	{
		TreeNode<T> node1 = checkAndGetIfNodeExist(this.root, data1);
		TreeNode<T> node2 = checkAndGetIfNodeExist(this.root, data2);
		
		IntegerRef d1 = new IntegerRef(-1);
		IntegerRef d2 = new IntegerRef(-1);
		int level = 0;
		
		int dist = findShortestDistBetweenNodesUtil(this.root, node1, node2, d1, d2, level);
		
		if(d1.value!=-1 && d2.value!=-1)
			return dist;
		
		if(d1.value!=-1)
			return findLevel(node1, node2, level);
		if(d2.value!=-1)
			return findLevel(node2, node1, level);
		
		return -1;
	}
	
	private int findShortestDistBetweenNodesUtil(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2, 
			IntegerRef d1, IntegerRef d2, int level)
	{
		if(root==null) {
			return -1;
		}
		
		if(root.equals(node1)) {
			d1.value = level;
			return d1.value;
		}
		if(root.equals(node2)) {
			d2.value = level;
			return d2.value;
		}
		
		int lsVal = findShortestDistBetweenNodesUtil(root.getLeft(), node1, node2, d1, d2, level+1);
		int rsVal = findShortestDistBetweenNodesUtil(root.getRight(), node1, node2, d1, d2, level+1);
		
		if(lsVal!=-1 && rsVal!=-1)
		{
			return lsVal+rsVal-(level<<1);
		}
		
		return (lsVal!=-1) ? lsVal : rsVal;
	}
	
	@Override
	public double findSumOfAllAtLevel(int level)
	{
		if(level<1)
			return -1;
		else
			return findSumOfAllAtLevel(this.root, 1, level);
	}
	
	private double findSumOfAllAtLevel(TreeNode<T> node, int curLevel, int keyLevel)
	{
		if(node==null)
			return 0;
		
		if(curLevel==keyLevel) {
			if (node.getData() instanceof Number)
				return ((Number) node.getData()).doubleValue();
			else
				throw new IllegalArgumentException("Allowed only for numerical Types");
		}
		
		return findSumOfAllAtLevel(node.getLeft(), curLevel+1, keyLevel)
				+ findSumOfAllAtLevel(node.getRight(), curLevel+1, keyLevel);
	}
	
	public int findDiameterOfTree()
	{
		if(Objects.isNull(this.root))
			return 0;
		
		IntegerRef maxHeight = new IntegerRef(0);
		return findDiameterOfTreeUtil(this.root, maxHeight);
	}
	
	private int findDiameterOfTreeUtil(TreeNode<T> node, IntegerRef maxHeight)
	{
		IntegerRef lsMaxHeight = new IntegerRef(0), rsMaxHeight = new IntegerRef(0);
		int lsDiameter = 0 , rsDiameter = 0;
		
		if(Objects.isNull(node))
		{
			maxHeight.value = 0;
			return 0;
		}
		
		lsDiameter = findDiameterOfTreeUtil(node.getLeft(), lsMaxHeight);
		rsDiameter = findDiameterOfTreeUtil(node.getLeft(), rsMaxHeight);
		
		maxHeight.value = Math.max(lsMaxHeight.value, rsMaxHeight.value) + 1;
		
		return Math.max(lsMaxHeight.value + rsMaxHeight.value + 1, Math.max(lsDiameter, rsDiameter));
	}
	
}
