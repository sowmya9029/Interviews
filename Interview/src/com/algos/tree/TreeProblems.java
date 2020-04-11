package com.algos.tree;

import java.util.ArrayList;

import com.algos.heap.Node;
import sun.tools.java.BinaryMember;


public class TreeProblems
{
	int max = 0;
	int countFullnodes=0;
	int counthalfNodes = 0;
	ArrayList<BinaryTreeNode> arrayList=new ArrayList<>();

	public int getMaxElement(BinaryTreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
		max= root.data;
		if(root.data>max)
		{
			max=root.data;
		}
		getMaxElement(root.left);
		getMaxElement(root.right);

		return max;
	}

	public BinaryTreeNode mirrorAtree(BinaryTreeNode root)
	{
		BinaryTreeNode temp;
		if(root!=null)
		{
			mirrorAtree(root.left);
			mirrorAtree(root.right);
			temp = root.left;
			root.left=root.right;
			root.right=temp;
		}
		return root;
	}

	public void printPath(BinaryTreeNode root,ArrayList<BinaryTreeNode> printPathList)
	{

		if(root==null)
		{
			return;
		}
		printPathList.add(root);
		printPath(root.left,printPathList);
		printPath(root.right,printPathList);
		if(root.left==null && root.right==null )
			System.out.println(printPathList);
		printPathList.remove(0);

	}

	public void findPath(BinaryTreeNode root, BinaryTreeNode node,ArrayList<Integer> path,ArrayList<BinaryTreeNode> printPathList)
	{
        //int path[] = new;
      //  ArrayList<Integer> path = new ArrayList<>();
		if(root==null)
		{
			return ;
		}
		printPathList.add(root);
		findPath(root.left,node,path,printPathList);
		findPath(root.right,node,path,printPathList);
		if(root==node )
         {
			for(BinaryTreeNode node1:printPathList)
			{
				path.add(node1.data);
			}
		 }
		printPathList.remove(0);
    // return path;
	}

	// returns true if trees with roots as root1 and root2 are mirror
	boolean isMirror(Node node1, Node node2)
	{
		// if both trees are empty, then they are mirror image
		if (node1 == null && node2 == null)
			return true;

		// For two trees to be mirror images, the following three
		// conditions must be true
		// 1 - Their root node's key must be same
		// 2 - left subtree of left tree and right subtree
		//      of right tree have to be mirror images
		// 3 - right subtree of left tree and left subtree
		//      of right tree have to be mirror images
		if (node1 != null && node2 != null && node1.key == node2.key)
			return (isMirror(node1.left, node2.right)
					&& isMirror(node1.right, node2.left));

		// if neither of the above conditions is true then
		// root1 and root2 are mirror images
		return false;
	}

	//different way of writing

	boolean areMirror(Node a, Node b)
	{
		/* Base case : Both empty */
		if (a == null && b == null)
			return true;

		// If only one is empty
		if (a == null || b == null)
			return false;

        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
		return a.data == b.data
				&& areMirror(a.left, b.right)
				&& areMirror(a.right, b.left);
	}

	public boolean sumOfPath(BinaryTreeNode root ,int sum)
	{
		if(root==null)
		{
			return false;
		}
		if(root.right==null &&root.left==null&&sum==root.data)
		{
			return true;
		}
		return sumOfPath(root.left,sum-root.data) ||sumOfPath(root.right,sum-root.data) ;
	}
	boolean isSibling(Node node, Node a, Node b)
	{
		// Base case
		if (node == null)
			return false;

		return ((node.left == a && node.right == b) ||
				(node.left == b && node.right == a) ||
				isSibling(node.left, a, b) ||
				isSibling(node.right, a, b));
	}

	// Recursive function to find level of Node 'ptr' in
	// a binary tree
	int level(Node node, Node ptr, int lev)
	{
		// base cases
		if (node == null)
			return 0;

		if (node == ptr)
			return lev;

		// Return level if Node is present in left subtree
		int l = level(node.left, ptr, lev + 1);
		if (l != 0)
			return l;

		// Else search in right subtree
		return level(node.right, ptr, lev + 1);
	}

	// Returns 1 if a and b are cousins, otherwise 0
	boolean isCousin(Node node, Node a, Node b)
	{
		// 1. The two Nodes should be on the same level
		//       in the binary tree.
		// 2. The two Nodes should not be siblings (means
		//    that they should not have the same parent
		//    Node).
		return ((level(node, a, 1) == level(node, b, 1)) &&
				(!isSibling(node, a, b)));
	}
	boolean isBalanced(Node node)
	{
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		if (Math.abs(lh - rh) <= 1
				&& isBalanced(node.left)
				&& isBalanced(node.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
	int height(Node node)
	{
		/* base case tree is empty */
		if (node == null)
			return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public boolean existenceOfPathWithSum(BinaryTreeNode root ,int sum)
	{
		if(root==null)
		{
			return false;

		}
		else if(root.data==sum)
		{
			return true;
		}
		else
		{
			return existenceOfPathWithSum(root.left,root.data) ||existenceOfPathWithSum(root.right,root.data );
		}
	}

	public int getMaxElementNoGlobal(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(root.data, Math.max(getMaxElementNoGlobal(root.left), getMaxElementNoGlobal(root.right)));
	}

	public int sizeOfTree(BinaryTreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
		return 1+getMaxElement(root.left)+getMaxElement(root.right);
	}

	public BinaryTreeNode getLeastCommonAncestor(BinaryTreeNode root, BinaryTreeNode a,BinaryTreeNode b)
	{
		if(root==null)
		{
			return null;
		}
		if(root==a || root ==b )
		{
			return root;
		}

		BinaryTreeNode lh = getLeastCommonAncestor(root.left,a,b);
		BinaryTreeNode lr = getLeastCommonAncestor(root.right,a,b);
		if(lh!=null && lr!=null)
	     {
		    return root;
	     }
		if(lh!=null)
		{
			return lh;

		}
		if(lr!=null)
		{
			return lr;

		}
    return root;
	}
	public BinaryTreeNode getParent(BinaryTreeNode root,BinaryTreeNode node)
	{
		if(root==null)
		{
			return null;
		}
		if(root.left.data == node.data|| root.right.data == node.data)
		{
			return root;
		}
		BinaryTreeNode nodel = getParent(root.left, node);
		BinaryTreeNode noder = getParent(root.right, node);
		if(nodel == null&& noder == null)
		{
			return null;
		}
		else if(nodel!= null)
		{
			return nodel;
		}
		else
		{
			return noder;
		}
	}

	 public int getTheAncestor(BinaryTreeNode root,BinaryTreeNode n1,BinaryTreeNode n2)
	   {
		 int leastCommonAncestor = 0;
		 ArrayList<Integer>  list1 =new ArrayList<>();
		 ArrayList<Integer>  list2 =new ArrayList<>();

		 findPath(root, n1 , list1, new ArrayList<>());
		 findPath(root, n2 , list2, new ArrayList<>());

		int size=0;
		if(list1.size() > list2.size())
		{
		  size = list2.size()-1;
		}
		else
		{
		  size = list1.size()-1;
		}

		for(int i=0;i<size;i++)
		{
           if(list1.get(i) == list2.get(i))
           {
        	      leastCommonAncestor=list1.get(i);
           }
		}

		  return leastCommonAncestor;
	   }

	public void deleteNode(BinaryTreeNode root,BinaryTreeNode deleteNode)
	{
		//BinaryTreeNode temp;
		if(root==null)
		{
			return ;
		}
		if(root.data==deleteNode.data)
		{
			BinaryTreeNode leafNode =getLeaf(root);
			if(leafNode!=null)
			{
				//temp =leafNode;
				leafNode=root;
				root= leafNode;
				root=null;
			}
		}
		deleteNode(root.left,deleteNode);
		deleteNode(root.right,deleteNode);
	}

	public BinaryTreeNode getLeaf(BinaryTreeNode root)
	{

		if(root.left==null && root.right==null)
		{
			return root;
		}
		getLeaf(root.left);
		getLeaf(root.right);
		return root;
	}

	public void levelOrderTraversal(BinaryTreeNode root)
	{
		ArrayList<BinaryTreeNode> nodeList = new ArrayList<>();
		ArrayList<BinaryTreeNode> treeList = new ArrayList<>();
		ArrayList<BinaryTreeNode> reverseTreeList = new ArrayList<>();
		nodeList.add(root);
		while(nodeList.size()!=0)
		{
			BinaryTreeNode node =nodeList.remove(0);
			System.out.print(node + " ");
			reverseTreeList.add(0,node);
			treeList.add(node);
			if(node.left!=null)
			nodeList.add(node.left);
			if(node.right!=null)
			nodeList.add(node.right);

		}
	}

	public ArrayList<ArrayList<BinaryTreeNode>> levelWiseTreeList(BinaryTreeNode root)
	{

		/*	2
		1       3
	 3    4   5     6
  4     5   6    7     8 */
		ArrayList<ArrayList<BinaryTreeNode>> listOfParents = new ArrayList<>();
		ArrayList<BinaryTreeNode> childList = new ArrayList<>();
		childList.add(root);
		listOfParents.add(childList);
		int currentParent=0;
		ArrayList<BinaryTreeNode> parentList = listOfParents.get(currentParent);
		while(parentList!=null)
		{
			ArrayList<BinaryTreeNode> list =new ArrayList<>();
			//currentParent++;
			for(BinaryTreeNode node :parentList) {
				if (node.left != null)
					list.add(node.left);

				if (node.right != null)
					list.add(node.right);
			}
			listOfParents.add(currentParent++,list);  // [{2},{1,3},{3,4,5,6},{}
			parentList = listOfParents.get(currentParent);
		}
		return listOfParents;
	}


	//print spiral instead of 2 queues replace queue with 2 stacks and do the same as below
	public  void levelByLevel(BinaryTreeNode root)
	{

		/*[	[2]
		[1 ,      3]
	[ 3   , 4  , 5    , 6]
  4     5   6    7     8]] */
		if(root==null) return;

		ArrayList<BinaryTreeNode> queue1 = new ArrayList<>();
		ArrayList<BinaryTreeNode> queue2 = new ArrayList<>();
		queue1.add(root);
		while(!queue1.isEmpty() || !queue2.isEmpty())
		{
			while(!queue1.isEmpty())
			{
				BinaryTreeNode node = queue1.remove(0);
				System.out.println(node.data);
				if(node.left!=null)
				queue2.add(node.left);
				if(node.right!=null)
				queue2.add(node.right);
			}
			System.out.println("");

			while(!queue2.isEmpty())
			{
				BinaryTreeNode node =queue2.remove(0);
				System.out.println(node.data);
				if(node.left!=null)
				 queue1.add(node.left);
				if(node.right!=null)
				 queue1.add(node.right);
			}
			System.out.println("");
		}

	}

	public int getDiameterOfList (ArrayList<ArrayList<BinaryTreeNode>> list)
	{
		int diameter = 0;
		for(ArrayList<BinaryTreeNode> nodeList : list)
		{
			if(diameter<nodeList.size())
			{
				diameter= nodeList.size();
			}
		}
		return diameter;
	}


	public boolean compareTwoTrees(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1==null && root2==null)
		{
			return true;
		}
		else if(root1!=null && root2!=null){
			if (root1.data == root2.data &&
				compareTwoTrees(root1.left, root2.left)&&
				compareTwoTrees(root1.right, root2.right)) {
				return true;
			}
		}

		return false;

	}



	public void countHalfAndFullNodes(BinaryTreeNode root)
	{
		if(root==null)
		{
			return ;
		}
		if(root.left!=null&& root.right!=null)
		{
			countFullnodes++;
		}
		else if(root.left!=null ||root.right!=null )
		{
			counthalfNodes++;
		}
		getMaxElement(root.left);
		getMaxElement(root.right);
	}

	public void insertNodeInTree(BinaryTreeNode root,BinaryTreeNode newNode)
	{
		if(root==null)
		{
			return;
		}
		if(root.left==null)
		{
			root.left=newNode;
		}
		else if(root.right==null)
		{
			root.right=newNode;
		}
		insertNodeInTree(root.left,newNode);
		insertNodeInTree(root.right,newNode);
	}

	public boolean searchElement(BinaryTreeNode root,BinaryTreeNode serachNode)
	{
		if(root!=null&&root.data==serachNode.data)
		{
			return true;
		}

		searchElement(root.left,serachNode);
		searchElement(root.right,serachNode);
		return false;
	}
}
