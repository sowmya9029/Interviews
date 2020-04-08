package com.algos.tree;

import java.util.ArrayList;
import java.util.Stack;

import com.algos.heap.Node;

public class TreeOperations
{

	void preOrderRecursive(BinaryTreeNode root) {
		System.out.println(root.data);
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	void inOrderRecursive(BinaryTreeNode root) {
		inOrderRecursive(root.left);
		System.out.println(root.data);
		inOrderRecursive(root.right);
	}

	void postOrderRecursive(BinaryTreeNode root) {
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
		System.out.println(root.data);
	}

	public ArrayList<Integer> preOrderNonRecursive(BinaryTreeNode root) {
		ArrayList<Integer> res= new ArrayList<>();
		Stack<BinaryTreeNode> treeStack = new Stack<>();
		treeStack.push(root);
		while(!treeStack.empty())
		{
			BinaryTreeNode node =treeStack.pop();
			res.add(node.data);
			if(node.right!=null)
			{
				treeStack.push(node.right);
			}
			if(node.left!=null)
			{
				treeStack.push(node.left);
			}
		}
		return res;
	}

	public ArrayList<Integer> inOrderNonRecursive(BinaryTreeNode root) {
		ArrayList<Integer> res= new ArrayList<>();
		Stack<BinaryTreeNode> treeStack = new Stack<>();
		BinaryTreeNode node = root;
		while(node!=null )
		{
			treeStack.push(node);
			node=node.left;
		}
		while(!treeStack.isEmpty())
		{
			node= treeStack.pop();
			res.add(node.data);
			//if(node.right!=null)
			//{
				node=node.right;

				while(node!=null)
				{
					treeStack.push(node);
					node=node.left;
				}
			//}
		}
		return res;
	}

	int heightTree(BinaryTreeNode root) {
		if(root==null)
		{
			return 0;
		}
		return 1+Math.max(heightTree(root.left),heightTree(root.right));
	}


	public BinaryTreeNode buildBinaryTree(String preOrder,String inOrder) {
		if(preOrder.length()!=inOrder.length())
		{
           return null;
		}
		else
		{
			return buildTree(preOrder,0,preOrder.length()-1,inOrder,0,inOrder.length()-1);
		}
	}


	private BinaryTreeNode buildTree(String preOrder, int preStart, String inOrder, int inOrderStart, int inOrderEnd) {
		// TODO Auto-generated method stub

        if(inOrderStart>inOrderEnd)
        {
            return null;
        }
		char data = preOrder.charAt(preStart);
		BinaryTreeNode node = new BinaryTreeNode(data);

		node.left=buildTree(preOrder,preStart+1,inOrder,inOrderStart,inOrder.indexOf(data)-1);
		node.right=buildTree(preOrder,inOrder.indexOf(data)+1,inOrder,inOrder.indexOf(data)+1,inOrderEnd);
		return node;
	}
}
