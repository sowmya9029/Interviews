package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Itinerary {
	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	Set<String> visited = new HashSet<String>();
	public List<String> findItinerary(String[][] tickets)
	{
		ArrayList<String> values;
		ArrayList<String> itineraryList = new ArrayList<String>();
		for(int rows = 0; rows < tickets.length; rows++) 
		{
			addAdj(tickets[rows][0],tickets[rows][1]);
		}
		//itineraryList.add(0,"JFK");
		//visited.add("JFK");
		dfs("JFK",itineraryList,visited);     
		return itineraryList;
	}
	public void addAdj(String v,String w)
	{
		ArrayList<String> list;
		if(map.containsKey(v))
		{                       
			map.get(v).add(w);
		}
		else
		{
			list= new ArrayList<String>();
			list.add(w);
			map.put(v,list);		   
		}
	}

	public void dfs(String source,ArrayList<String> itineraryList,Set visited)
	{
		ArrayList<String> nodeList = map.get(source);		
		if(nodeList!=null)
		{                      
			Collections.sort(nodeList);
			for(int i=0;i<nodeList.size();i++)
			{			   
				if(visited.add(source+":"+nodeList.get(i)))
				{                            
					dfs(nodeList.get(i),itineraryList,visited); 
				}
				//endb if
			}
		}
		itineraryList.add(0,source);	                    
	}
}
