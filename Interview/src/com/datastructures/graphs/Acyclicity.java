package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Acyclicity {
	static Set<String> markSet = new HashSet<>();
	private static int acyclic(ArrayList<Integer>[] adj) {
		//write your code here

		   int result = 0;
		  boolean t = false;
		for(int i=0;i<adj.length;i++)
	        {
			for(int j: adj[i]) {
				if(markSet.contains(j+":"+i)) {
					System.out.print(j+":"+i);
					t = true;
				}
			}
			
	        	 if(!t)
	        	 {	        	
	        	  result = reach(adj, i);
	        	  if(result == 1) {
	        		  return result;
	        	  }
	        	 }
	        	 t = false;  
	        }
		return result;
	}
    private static int reach(ArrayList<Integer>[] adj, int x) {
        //write your code here  
    	          		   		     		
		 ArrayList<Integer> list = new ArrayList<Integer>();	
		 
				//int src = graph.getGraphNode(source);
				//src.setMark(true);
		    
			    list.add(x);
			
				while (list.size()!=0)
				{
					//System.out.println(list.remove(0).getMark()+"");
					int number= list.remove(0);							
					 						
						for(int i :adj[number])
						{
//							System.out.println(markSet);
							if(markSet.add(i+":"+number))
							{							  
							   list.add(i); 
							}
							else
							{
								System.out.print(i+":"+number);
								return 1;
							}
						}						  
				}
				
		return 0;			
		   
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			adj[x - 1].add(y - 1);
		}
		System.out.println(acyclic(adj));
	}
}

