package com.datastructures.graphs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Reachability {
 
	private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here  
    	          		   		     		
		 ArrayList<Integer> list = new ArrayList<Integer>();	
		 Set<Integer> markSet = new HashSet<>();
				//int src = graph.getGraphNode(source);
				//src.setMark(true);
		    
			list.add(x);
			
				while (list.size()!=0)
				{
					//System.out.println(list.remove(0).getMark()+"");
					int number= list.remove(0);			
					if(y == number)
					{
						return 1;
					}
					else
					{  						
						for(int i :adj[number])
						{
							//System.out.println(i.getMark());
							if(markSet.add(i))
							{							  
							   list.add(i); 
							}
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

