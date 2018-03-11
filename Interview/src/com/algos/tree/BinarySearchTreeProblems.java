package com.algos.tree;

import com.datastructures.linkedlists.SingleLinkedList;
import com.datastructures.linkedlists.SingleLinkedListNode;

public class BinarySearchTreeProblems 
{
	private int predecessor;
	private int sucessor;BinaryTreeNode rootParent;

	public BinarySearchTreeProblems(BinaryTreeNode root) {
		// TODO Auto-generated constructor stub
		this.rootParent=root;
	}
	boolean searchTree(BinaryTreeNode root,int data)
	{
		if(root==null)
		{
			return false;

		}
		if(root.data==data)
		{
			return true;
		}
		else if(root.data<data)
		{
			return searchTree(root.right, data);
		}
		else
		{
			return searchTree(root.left, data);
		}
	}
	boolean isValidBinarySearchTree(BinaryTreeNode root,int min,int max)
	{
		if(root==null)
		{
			return true;
		}
		if(root.data <max&&root.data>min)
		{
			return (isValidBinarySearchTree(root.left, min, root.data)&&isValidBinarySearchTree(root.right, root.data,max));
		}
		return false;
	}

	public BinaryTreeNode getLCA(BinaryTreeNode root,BinaryTreeNode a,BinaryTreeNode b)
	{
		if(root==null)
		{
			return root;
		}
		if(root.data==a.data || root.data==a.data)
		{
			return root;
		}
		if(Math.max(a.data, b.data)<root.data)
		{
			return getLCA(root.left,a,b);
		}
		else if(Math.min(a.data, b.data)<root.data)
		{
			return getLCA(root.right,a,b);
		}
		else
			return root;
	}

	public BinaryTreeNode BuildBinaryTreeFromArray(int a[],int left,int right)
	{
		BinaryTreeNode node;
		if(left>right)
			return null;
		int mid= left+(right-left)/2;
		node = new BinaryTreeNode(a[mid]);		
		node.left = BuildBinaryTreeFromArray(a, left, mid-1);
		node.right = BuildBinaryTreeFromArray(a, mid+1, right);
       return node;
	
	//node= new BinaryTreeNode(data)
}
	 int countNodes(SingleLinkedListNode head) 
	    {
	        int count = 0;
	        SingleLinkedListNode temp = head;
	        while (temp != null)
	        {
	            temp = temp.next;
	            count++;
	        }
	        return count;
	    }
	 //count thenumber of nodes in list and call BSTFromLinkedListRescurse
	BinaryTreeNode BSTFromLinkedList(SingleLinkedListNode node)
	{
		int n =countNodes(node);
		return BSTFromLinkedListRescurse(n);
	}
	public BinaryTreeNode BSTFromLinkedListRescurse(int n)
	{
		if (n<0)
		{
			return null;
		}
		BinaryTreeNode left = BSTFromLinkedListRescurse(n/2);
		BinaryTreeNode root = BinaryTreeNode(Integer.parseInt(SingleLinkedList.head.getData()));
		root.left=left;
		SingleLinkedList.head=SingleLinkedList.head.getNext();
		root.right=BSTFromLinkedListRescurse(n-n/2-1);
		return root;
	}
	
	
public BinaryTreeNode delete(BinaryTreeNode root,BinaryTreeNode node)
{
	if(root.data>node.data)
	{
		root.left = delete(root.left, node);
	}
	else if(root.data<node.data)
	{
		root.right=delete(root.right,node);
	}
	else
	{
		if(root.left!=null && root.right!=null)
		{
			BinaryTreeNode temp;
			//getting the predecessor which is the greatest ele in the left sub tree;
			temp=getMax(root.left);
			root.data=temp.data;
			//validate
			
			root.left = delete(root.left,temp);
		}
		else
		{
			if(root.left==null)
			{
				root=root.right;
			}
			if(root.right==null)
			{
				root=root.left;
			}

		}
	}
	return root;
}


//right diferent methods and return int
public void predecesorAndSucceorOfBST(BinaryTreeNode root,int value) {

	if(root==null)
	{
		return ;
	}
	if(root.data==value)
	{
		
		
		
		BinaryTreeNode parent =getParent(rootParent,root);		
		while(root==parent.left) {
			root = parent;
			parent = getParent(rootParent,root);
		}
		predecessor = parent.data;
		
		
		if(root.left!=null)
			predecessor=getMax(root.left).data;

		if(root.right!=null)
			sucessor=getMin(root.right).data;
		
		while(root==parent.right) {
			root = parent;
			parent = getParent(rootParent,root);
		}
		sucessor = parent.data;

	}

	if(value < root.data ) {
		predecesorAndSucceorOfBST(root.left,value);
	} 
	if(value > root.data) {
		predecesorAndSucceorOfBST(root.right, value);
	}
}

//public int pre(BinaryTreeNode root)
public BinaryTreeNode getMax(BinaryTreeNode root)
{
	//int max=0;
	while(root.right!=null)
	{
		root=root.right;		
	}
	return root;
}
public BinaryTreeNode getParent(BinaryTreeNode root,BinaryTreeNode node)
{
	if(root==null)
	{
		return null;
	}
	if(root.left.data==node.data|| root.right.data==node.data)
	{
		return root;
	}
	BinaryTreeNode nodel=getParent(root.left, node);
	BinaryTreeNode noder=getParent(root.right, node);
	if(nodel==null&& noder==null)
	{
		return null;
	}
	else if(nodel!=null)
	{
		return nodel;
	}
	else
	{
		return noder;
	}
}
public BinaryTreeNode getParentBST(BinaryTreeNode root,BinaryTreeNode node)
{
	if(root==null)
	{
		return null;
	}
	if(root.left.data==node.data|| root.right.data==node.data)
	{
		return root;
	}
	
	if(root.data<node.data)
	{
		return getParent(root.right, node);
	}
	else
	{
		return getParent(root.left, node);
	}
}
public BinaryTreeNode getMin(BinaryTreeNode root)
{
	//int max=0;
	while(root.left!=null)
	{
		root=root.left;		
	}
	return root;
}
}