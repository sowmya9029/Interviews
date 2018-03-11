package com.algos.tree;

import java.util.ArrayList;

import com.algos.heap.Node;



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
		if(root==node || root==node )
		 {						
			for(BinaryTreeNode node1:printPathList)
			{
				path.add(node1.data);
			}
		 }
		printPathList.remove(0);
    // return path;
	}
	
	
	public boolean sumOfPath(BinaryTreeNode root ,int sum)
	{
		if(root==null)
		{
			return false;
		}
		if(root.right==null&&root.left==null&&sum==root.data)
		{
			return true;
		}
		return sumOfPath(root.left,sum-root.data) ||sumOfPath(root.right,sum-root.data) ;
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
	 public int getTheAncestor(BinaryTreeNode root,BinaryTreeNode n1,BinaryTreeNode n2)
	   {
		 int leastCommonAncestor=0;
		 ArrayList<Integer>  list1 =new ArrayList<>();
		 ArrayList<Integer>  list2 =new ArrayList<>();
		
		 findPath(root, n1,list1 , new ArrayList<>());
		 findPath(root, n2, list2, new ArrayList<>()); 
		
		int size=0;
		if(list1.size()>list2.size())
		{
		  size=list2.size()-1;
		}
		else
		{
		  size=list1.size()-1;
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

	public ArrayList<ArrayList<BinaryTreeNode>> levelWiseTreeList(BinaryTreeNode root)
	{

		/*			2
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
			for(BinaryTreeNode node :parentList)
			{
				if(node.left!=null)
					list.add(node.left);

				if(node.right!=null)
					list.add(node.right);

				listOfParents.add(currentParent,list);  // [{2},{1,3},{3,4,5,6},{}
			}
			currentParent++;
			parentList = listOfParents.get(currentParent);
		}


		return listOfParents;

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

	public void levelOrderTraversal(BinaryTreeNode root)
	{
		ArrayList<BinaryTreeNode> nodeList = new ArrayList<>();
		ArrayList<BinaryTreeNode> treeList = new ArrayList<>();
		ArrayList<BinaryTreeNode> reverseTreeList = new ArrayList<>();
		nodeList.add(root);
		while(nodeList.size()!=0)
		{
			BinaryTreeNode node =nodeList.remove(0);
			reverseTreeList.add(0,node);
			treeList.add(node);
			nodeList.add(node.left);
			nodeList.add(node.right);

		}
	}
	public boolean compareTwoTrees(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1==null && root2==null)
		{				
			return false; 
		}	
		if(root1.left.data==root2.left.data && root2.right.data==root1.right.data)
		{
			compareTwoTrees(root1.left,root2.left);
			compareTwoTrees(root1.right,root2.right);
			return true; 
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
