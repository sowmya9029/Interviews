package com.datastructures.graphs;

import java.util.ArrayList;

public class GraphMain {
	
	public static void main( String agrs[])
	{
		Graphs graph = new Graphs();
		GraphNode one = new GraphNode(1,false);
		GraphNode two = new GraphNode(2,false);
		GraphNode three = new GraphNode(3,false);
		GraphNode four = new GraphNode(4,false);
		GraphNode five = new GraphNode(5,false);

		graph.addDirectedEdge(one, two);
		graph.addDirectedEdge(one, three);
		graph.addDirectedEdge(four, five);
		graph.addDirectedEdge(three, two);
		graph.addDirectedEdge(three, five);		
		graph.addDirectedEdge(two, four);
		graph.printGraph();				
		BFS bfs = new BFS(graph);
		//System.out.println("Breadth first search :"+ bfs.search(1,five));
		
		DFS dfs = new DFS(graph);
		//dfs.dfs(one);
		//System.out.println(dfs.dfsConnectedComponents(one));
		System.out.println(dfs.topologicalSort());
		//dfs.printPath(one,five);
		//System.out.println(dfs.printPath(one,five));
		//graph.printCompleteGraph();
	}

}
