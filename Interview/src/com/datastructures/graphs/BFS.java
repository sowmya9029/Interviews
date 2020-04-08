package com.datastructures.graphs;

import java.util.ArrayList;

public class BFS 
{
	ArrayList<GraphNode> list;
	Graphs graph;
	BFS(Graphs graph)
	{ 	 
		this.graph = graph;
	}
    
	boolean search(int source, GraphNode destination)
	{
		list = new ArrayList<GraphNode>();
	
		GraphNode src = graph.getGraphNode(source);
		src.setMark(true);
		
		list.add(src);
		while (list.size()!=0)
		{
			//System.out.println(list.remove(0).getMark()+"");
			GraphNode number= list.remove(0);			
			if(destination == number)
			{
				return true;
			}
			else
			{  
				for(GraphNode i :graph.adj(number))
				{
					//System.out.println(i.getMark());
					if(i.isMark()==false)
					{
					   i.mark=true;
					   list.add(i); 
					}
				}
			}	  
		}
		return false;
	}

}


