package com.algos.sands;



public class BinarySearch 
{
	
	boolean search(int low,int high,int key,int[] array)
	{
		if(low >= high)
		{
			return false;
		}

		int mid =low+(high-low)/2;
		
		if(key==array[mid])
	    {
		   return true;
	    }
//		if(low>high &&low+1==high)
//		{		
//			return false;
//		}
		if(key<array[mid])
		{
			return  search(low, mid-1, key,array);
		}
		else
		{
			return  search(mid+1, high, key,array);	
		}
	}
	
	//search in sorted matrix 
		private static void search(int[][] mat, int n, int x) {
	        
	        int i = 0, j = n-1;  //set indexes for top right
	                             // element
	          //last element 1st row
	          while ( i < n && j >= 0 )
	          {
	             if (mat[i][j] == x)
	             {
	                System.out.print("n Found at "+ i + " " + j);
	                return;
	             }
	             //go left
	             if ( mat[i][j] > x )
	               j--;
	             //go down
	             else //  if mat[i][j] < x
	               i++;
	          }
	          System.out.print("n Element not found");
	          return;  // if ( i==n || j== -1 )
	   }
	int ceilSearch(int low,int high,int key,int[] a)
	{
		if(low>high)
		{
			return low;
		}
		int mid =low+(high-low)/2;
		if(key<a[mid])
		{
			return  ceilSearch(low, mid-1, key,a);
		}
		else
		{
			return  ceilSearch(mid+1, high, key,a);	
		}
	}
}