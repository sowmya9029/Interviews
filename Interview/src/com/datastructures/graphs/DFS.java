package com.datastructures.graphs;

import java.util.ArrayList;

public class DFS 
{

	Graphs graph;
	static long globalTime; 
	ArrayList<GraphNode> nodeList;
	ArrayList<GraphNode> sortList;
	private ArrayList pathList;
	DFS(Graphs graph)
	{	  
		this. graph = graph;
	}
	public ArrayList<GraphNode> topologicalSort()
	{
		//int count =0;	
		sortList = new ArrayList<>();
		for(GraphNode node : graph.adjList.keySet()) 
		{
			node.setMark(false);
		}
	//	source.setMark(true);	
		for(GraphNode node : graph.adjList.keySet()) 
		{
			if(!node.isMark())
			{
				//count++;				
				//source.setSetStartTime(globalTime++);
				search(node);
				//source.setSetEndTime(globalTime++);
			}
		}
		
        return sortList;
	}
	public int dfsConnectedComponents(GraphNode source)
	{
		int count =0;
		
		for(GraphNode node : graph.adjList.keySet()) 
		{
			node.setMark(false);
		}
		source.setMark(true);	
		for(GraphNode node : graph.adjList.keySet()) 
		{
			if(!node.isMark())
			{
				count++;				
				source.setSetStartTime(globalTime++);
				search(source);
				source.setSetEndTime(globalTime++);
			}
		}
		
        return count;
	}
	public ArrayList<GraphNode> printPath(GraphNode source,GraphNode destination)
	{
		ArrayList<GraphNode>	 pathList = new ArrayList<GraphNode>();
		for(GraphNode node : graph.adjList.keySet()) {
			node.setMark(false);
		}
		source.setMark(true);
		source.setSetStartTime(globalTime++);
		//pathList.add(source);
		search(source,destination,pathList);
		source.setSetEndTime(globalTime++);
		return pathList;
	}
	public void dfs(GraphNode source)
	{
		for(GraphNode node : graph.adjList.keySet()) {
			node.setMark(false);
		}
		source.setMark(true);
		source.setSetStartTime(globalTime++);
		search(source);
		source.setSetEndTime(globalTime++);
	}
	public void search(GraphNode source)
	{
		System.out.println("source "+source);	   
		//list.remove(0).getVertice()
		ArrayList<GraphNode> nodeList = graph.adj(source);
		source.setSetStartTime(globalTime++);
		source.setMark(true);
		if(nodeList==null)
		{
			sortList.add(0,source);
			source.setSetEndTime(globalTime++);
			return;
		}
		for(GraphNode node : nodeList)
		{			   
			// System.out.println("node vertex " +node.getVertice() +" node mark "+node.getMark() );			   
			if(node.isMark()==false)
			{				
				node.setParent(source.getVertice());
				search(node);
			}			    
		}
		sortList.add(0,source);
		source.setSetEndTime(globalTime++);
	}   
	public void search(GraphNode source,GraphNode destination,ArrayList<GraphNode> pathList)
	{		
		System.out.println("source "+source);	   
		//list.remove(0).getVertice()
		if(source.equals(destination))
		{
            System.out.println(pathList);
		}
		ArrayList<GraphNode> nodeList = graph.adj(source);
		source.setMark(true);
		if(nodeList==null)
		{
			return;
		}
		for(GraphNode node : nodeList)
		{			   	   
//			if(node.isMark()==false)
//			{	
				pathList.add(0,source);
				node.setParent(source.getVertice());
				search(node,destination,pathList);
				
				pathList.remove(0);
		//	}			    
		}
		//pathList.add(0,source);
		
		//sortList.add(0,source);
		//source.setSetEndTime(globalTime++);
	}   
	
	  
} 
