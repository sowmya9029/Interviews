package com.datastructures.graphs;

import java.util.Comparator;

public class GraphNodeComparator implements Comparator<GraphNode> {

	@Override
	public int compare(GraphNode o1, GraphNode o2) {
		// TODO Auto-generated method stub
		if(o1.getDistance()<o2.getDistance())
		{
			 return -1;
		}
		else if(o1.getDistance()>o2.getDistance())
		{
			 return 1;
		}
		else
		{
			return 0;
		}
		
	}

}
