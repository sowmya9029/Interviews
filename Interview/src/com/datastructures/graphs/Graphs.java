package com.datastructures.graphs;    

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Graphs {
	//int vertice;
	int edge;
	HashMap<GraphNode, ArrayList<GraphNode>> adjList ;

	public Graphs()  {
		adjList = new HashMap<GraphNode,ArrayList<GraphNode>>();
	}
	//adding edge to the graph
	public void addEdge(GraphNode v,GraphNode w)
	{
		edge++;
		ArrayList<GraphNode> list;
		if(adjList.containsKey(v))
		{
		//	GraphNode node = new GraphNode(w, false);
			adjList.get(v).add(w);
		}
		else
		{
			list= new ArrayList<GraphNode>();
			//GraphNode node = new GraphNode(w, false);
			list.add(w);
			adjList.put(v,list);		   
		}

		if(adjList.containsKey(w))
		{
		//	GraphNode node = new GraphNode(v, false);
			adjList.get(w).add(v);
		}
		else
		{			
			list= new ArrayList<GraphNode>();
			//GraphNode node = new GraphNode(v, false);
			list.add(v);
			adjList.put(w,list);
		}

	}
	public void addDirectedEdge(GraphNode v,GraphNode w)
	{
		edge++;
		ArrayList<GraphNode> list;
		if(adjList.containsKey(v))
		{
		//	GraphNode node = new GraphNode(w, false);
			adjList.get(v).add(w);
		}
		else
		{
			list= new ArrayList<GraphNode>();
			//GraphNode node = new GraphNode(w, false);
			list.add(w);
			adjList.put(v,list);		   
		}	
	}
	
	void addDirectedEdgeWithWeight(GraphNode v,GraphNode w,int weight)
	{
		addDirectedEdge(v,w);
		Edge edge= new Edge(v, w,weight);
		v.getOutGoingEdge().add(edge);
	}
	
	void Dijkstra(GraphNode source)
	{
		PriorityQueue<GraphNode> pq= new PriorityQueue<>(adjList.size(),new GraphNodeComparator());
		for(GraphNode node:adjList.keySet())
		{
			node.setDistance(Integer.MAX_VALUE);
			pq.add(node);
		}
		source.setDistance(0);
		while(!pq.isEmpty())
		{
			GraphNode node=pq.poll();
			for(Edge edge : node.getOutGoingEdge())
			{
				relax(node,edge);
			}
		}
	}
	
	
	private void relax(GraphNode node, Edge edge) {
		if(node.getDistance()+edge.weight<edge.destination.distance)
		{
			edge.destination.distance=node.getDistance()+edge.weight;
			edge.destination.setParent(node.getVertice());
		}
		
	}

	public GraphNode getGraphNode(int find)
	{
		for(GraphNode node : adjList.keySet())
			
		{
			if(node.getVertice()==find)
			{
				return node;
			}
				
		}
		return null;
	}
	
	//returns all vertices adj to given vertice
	public ArrayList<GraphNode> adj(GraphNode v)
		{   	   
			if(adjList!=null)
			{
				
				return adjList.get(v);
			}
			else
			{
				return null;
			}

		}
		
	
	//returns number of edges
	int E()
	{
		return edge;
	}
	//returns number of edges
	int V()
	{
		return adjList.size();
	}

	void printGraph()
	{
		for(GraphNode key :adjList.keySet() )
		{
			System.out.print(key.getVertice()+"-->");
			for(int j=0;j<adj(key).size();j++)
			{		  
				System.out.print(",");
				System.out.print(adj(key).get(j).getVertice());
			}
			System.out.println("");
		}
	}

	void printCompleteGraph()
	{
		for(GraphNode key :adjList.keySet() )
		{
			System.out.print(key);
		}
	}

}
