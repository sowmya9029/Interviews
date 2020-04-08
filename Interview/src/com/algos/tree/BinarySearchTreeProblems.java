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
		if(root.data < max && root.data> min)
		{
			return (isValidBinarySearchTree(root.left, min, root.data)&&isValidBinarySearchTree(root.right, root.data,max));
		}
		return false;
	}

	public BinaryTreeNode getLCA(BinaryTreeNode root,BinaryTreeNode a,BinaryTreeNode b)
	{
		if(root==null)
		{
			return null;
		}
		if(root.data==a.data || root.data==b.data)
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

	// converts a given linked list representing a
	// complete binary tree into the linked
	// representation of binary tree.
	BinaryTreeNode convertList2Binary(BinaryTreeNode node)
	{
		// queue to store the parent nodes
		Queue<BinaryTreeNode> q =
				new LinkedList<BinaryTreeNode>();

		// Base Case
		if (head == null)
		{
			node = null;
			return null;
		}

		// 1.) The first node is always the root node, and
		//     add it to the queue
		node = new BinaryTreeNode(head.data);
		q.add(node);

		// advance the pointer to the next node
		head = head.next;

		// until the end of linked list is reached, do the
		// following steps
		while (head != null)
		{
			// 2.a) take the parent node from the q and
			//      remove it from q
			BinaryTreeNode parent = q.peek();
			BinaryTreeNode pp = q.poll();

			// 2.c) take next two nodes from the linked list.
			// We will add them as children of the current
			// parent node in step 2.b. Push them into the
			// queue so that they will be parents to the
			// future nodes
			BinaryTreeNode leftChild = null, rightChild = null;
			leftChild = new BinaryTreeNode(head.data);
			q.add(leftChild);
			head = head.next;
			if (head != null)
			{
				rightChild = new BinaryTreeNode(head.data);
				q.add(rightChild);
				head = head.next;
			}

			// 2.b) assign the left and right children of
			//      parent
			parent.left = leftChild;
			parent.right = rightChild;
		}

		return node;
	}

	/**
	 * 1 2 3 4 5
	 * 					3
	 * 			1			4
	 * 				2			5
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
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

	/**
	 * 1 -> 2 -> 3 -> 4
	 * n = 4 n/2 = 2
	 * n = 2 n/2 = 1
	 * n = 1 n/2 = 0
	 * n = 0 -> tree with one formed
	 *
	 *                           3
	 *
	 * 						2                 4
	 * 					1		n
	 * 				n		n

	 *
	 * 			2
	 * 		1		3
	 * 					4
	 *

	 *
	 *n
	 *
	 * @param n
	 * @return
	 */
	public BinaryTreeNode BSTFromLinkedListRescurse(int n)
	{
		if (n<=0)
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
		root.right = delete(root.right,node);
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

public void predecesorAndSucceorOfBST(BinaryTreeNode root,int value) {

	if(root==null)
	{
		return ;
	}
	//if key is present
	if(root.data==value)
	{
      if(root.left!=null)
	  {
	  	//largest value in the left subtree is predecessor
	  	 predecessor = getMax(root.left).data;
	  }
	  if(root.right!=null)
	  {
	  	//smallest value in the right subtree is the successor
	  	sucessor = getMin(root.right).data;
	  }
	}

	if(value < root.data )
	{
		//if value is less than the root then root is the successor  and search recursively  in left subtree
		sucessor = root.data;
		predecesorAndSucceorOfBST(root.left,value);
	}
	  //if value is greater than the root then root is the predecessor and search recursively in right subtree
	else if (value > root.data)
	{
		predecessor = root.data;
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
		return getParentBST(root.right, node);
	}
	else
	{
		return getParentBST(root.left, node);
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

BinaryTreeNode delete_practice(BinaryTreeNode root,BinaryTreeNode val)
{
	if (root==null)
	{
		return null;
	}
	if(val.data<root.data)
	{
		root.left = delete_practice(root.left,val);
	}
	else
	{
		root.right = delete_practice(root.right,val);
	}
	if(root.data == val.data && root.left == null && root.right == null)
	{
       return null;
	}

	if(root.data == val.data && root.left == null)
	{
		return root.right;
	}
	if(root.data == val.data && root.right == null)
	{
		return root.left;
	}
	if(root.data==val.data && root.left!=null && root.right!=null)
	{
		BinaryTreeNode node = getMax(root.left);
		root.data = node.data;
		root.left = delete_practice(root.left,node);
	}
}
}