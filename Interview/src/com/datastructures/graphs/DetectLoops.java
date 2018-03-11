package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class DetectLoops
{
	HashMap <String,ArrayList<String>> graph = new HashMap<String,ArrayList<String>>();
	Set<String> mark = new HashSet<String>();
	boolean visited=false;
	ArrayList<String> listNode;
	String source="";
	static int countNumberOfLoops =0;
	public boolean detectLoops(String tickets[][])
	{
		for(int row=0;row<tickets.length;row++)
		{
			addAdj(tickets[row][0],tickets[row][1]);
		}    
        for(String src:graph.keySet())
        {
        	if(!mark.contains(src))
		    dfs(src,mark);
        }
		return visited;
	}

	public void addAdj(String v,String w)
	{
		if(graph.containsKey(v))
		{
			graph.get(v).add(w);
		}
		else
		{
			listNode = new ArrayList<String>();
			listNode.add(w);
			graph.put(v,listNode);
		}		
		/*for undirected graph
		 * if(graph.containsKey(w))
		{
			graph.get(w).add(v);
		}
		else
		{
			listNode = new ArrayList<String>();
			listNode.add(v);
			graph.put(w,listNode);
		}*/
	}

	public void dfs(String source,Set<String> mark)
	{
	
		ArrayList<String> sourceListNode = graph.get(source);
		if(sourceListNode!=null)
		{
			for(int i=0;i<sourceListNode.size();i++)
			{
				if(mark.add(source))
				{					
					dfs(sourceListNode.get(i),mark);
					//visited=false;					
				}
				else
				{
					visited = true;
					countNumberOfLoops++;
				}
			}
		}          
	}
}