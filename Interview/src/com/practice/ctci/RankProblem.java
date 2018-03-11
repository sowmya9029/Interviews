package com.practice.ctci;

public class RankProblem {


	
	
	public RankNode insertNode(RankNode node,int data)
	{
		if(node==null)
		{
			node = new RankNode(data);
		}
		else
		{
			if(data<node.data)
			{
				node.count++;
				node.left = insertNode(node.left, data);	
			}
			else 
			{
				node.right = insertNode(node.right, data);
			}
		}
		return node;
	}
	
	public int getRank(RankNode root,int d,int count)
	{
		int result = count;
		if(root==null)
		{
			return 0;
		}
		if(root.data==d)
		{
			return result;
		}
		else if(root.data<d)
		{
			result+=root.count;
			result++;
			return getRank(root.right, d,result);
		}
		else
		{
			return getRank(root.left, d,result);
		}
//		return result;
	}
	public class RankNode
	{
		int data =0;
		int count=0;
		RankNode left,right;
		RankNode(int data)
		{
			this.data=data;
		}
	}
}
