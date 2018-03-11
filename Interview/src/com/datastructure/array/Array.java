package com.datastructure.array;

import java.util.Arrays;

public class Array 
{

	int largestSum(int array[])
	{
		int maxSum=array[0],runSum=array[0];
		for (int i = 1; i < array.length; i++)
		{	
			runSum += array[i];	
			if(runSum<0||array[i]>runSum)
			{					
				runSum=array[i];
			}				
			if(runSum>maxSum)				
			{				
				maxSum=runSum;
			}	
		}				
		return maxSum;
	}
	int[] reverseArray(int array[])
	{
		int temp=0;
		int[] revarray=array;
		for (int i = 0; i < array.length/2; i++) {
			temp= revarray[revarray.length-i-1];
			revarray[revarray.length-i-1]=revarray[i];
			revarray[i]=temp;		

		}
		return	revarray;
	}
	void setColRowToZero(int [][]array)
	{
		int [][]tempArray = new int[array.length][array[0].length];
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				tempArray[row][col]=array[row][col];
			}
		}
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{

				if(array[row][col]==0)
				{
					System.out.println(array[row][col]);
					for(int l = 0; l < array.length; l++)
					{					
						tempArray[l][col] = 0;
					}	
					for(int l = 0; l < array[row].length; l++)
					{					
						tempArray[row][l] = 0;
					}	
				}
			}
		} 	  
		for (int row = 0; row < tempArray.length; row ++)
		{
			for (int col = 0; col < tempArray[row].length; col++)
			{
				System.out.print(tempArray[row][col]+" ");
			}
			System.out.println();
		}

	}
	void  leader(int array[])
	{ 

		int[] revarray = reverseArray(array);
		int  learder=array[0];
		System.out.println(array[0]);
		for(int i=0;i<revarray.length;i++)
		{  		   
			if(learder<revarray[i])
			{
				learder=revarray[i];
				System.out.println(learder);
			}
		}
	}

	boolean  pairWithSum(int array[],int x)
	{ 
		Arrays.sort(array);
		int l=0;
		int r=array.length-1;
		 while (l < r)
	        {
	             if(array[l] + array[r] == x)
	                  return true; 
	             else if(array[l] + array[r] < x)
	                  l++;
	             else 
	                  r--;
	        } 
		 return false;

	}
	
	void rotate90degrees(int a[][],int n)
	{
		int rowS=0;int colS=0;int rowE=a.length-1; int colE= a[0].length-1;
		for(int j=0;j<=n/2;j++)
		{
			int current_temp = a[0][0];
			for(int i=rowS;i<=(rowE-rowS);i++)
			{
				int new_temp = a[i][colE];
				a[i][colE]=current_temp;
				current_temp=new_temp;
				new_temp=a[rowE][colE-i];
				a[rowE][colE-i]=current_temp;
				current_temp=new_temp;
				new_temp=a[rowE-i][colS];
				a[rowE-i][colS]=current_temp;
				current_temp=new_temp;
				a[rowS][i]=current_temp;			
			}
			rowS++;
			rowE--;
			colS++;
			colE--;			
		}
	}
	
	void printSpiral(int [][]array)
	{
		int colS = 0;
		int colE = array[0].length-1;
		int rowS = 0;
		int rowE = array.length-1;
		
		while(colS<=colE&&rowS<=rowE)
		{
			for (int col = colS; col <= colE; col++)
			{
				System.out.print(array[rowS][col] + " ");
			}
			rowS++;
			System.out.println();
			for (int row = rowS; row <=rowE; row++)
			{
				System.out.print(array[row][colE] + " ");
			}
			System.out.println();
			colE--;
			for (int col = colE; col >=colS; col--)
			{			
				System.out.print(array[rowE][col] + " ");
			}
			System.out.println();
			rowE--;
			for (int row = rowE; row >=rowS; row --)
			{			
				System.out.print(array[row][colS] + " ");
			}
			colS++;
			System.out.println();
		}
	}
	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		for(int i=0;i<len;i++)
		{
			System.out.println(i);
			while(nums[i]==val&& i<len)
			{
				System.out.println(nums[i]+"--"+len+"--"+i);
				nums[i]=nums[--len];             
			}
		}
		return len;


	}
	//inplace remove element
	public int removeElement(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}
	
	
	
	int reversDigits(int num)
	{
	    int rev_num = 0;
	    int pre_num =0;
	    int curr_digit=0;
	    while (num > 0)
	    {
	    	    curr_digit = num%10;
	        rev_num = rev_num*10+ curr_digit;
	        if ((rev_num - curr_digit)/10 != pre_num)
            {
                System.out.println("WARNING OVERFLOWED!!!");
                return 0;
            }
	        pre_num=rev_num;
	        num = num/10;
	    }
	    return rev_num;
	}
	
	public boolean isPalindrome(int x) {
	    if (x<0 || (x!=0 && x%10==0)) return false;
	    int rev = 0;
	    while (x>rev){
	    	rev = rev*10 + x%10;
	    	x = x/10;
	    }
	    return (x==rev || x==rev/10);
	}
}