package com.algos.sands;

public class Sorting {

	void selectionSort(int []array,int n)
	{ 
		int min_index;
		int temp;
		for(int i=0;i<n-1;i++)
		{
			min_index =i;
			for(int j=i+1;j<n;j++)
			{
				if(array[j]<array[min_index])
				{
					min_index=j;
				}
			}
			temp = array[i];
			array[i]=array[min_index];
			array[min_index]=temp;
		}

	}
	void bubbleSort(int []array,int n)
	{
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<=n-k-1;i++)  //n-2
			{
				if(array[i]>array[i+1])
				{
					int	temp = array[i];
					array[i]=array[i+1];
					array[i+1]=temp;
				}

			}
		}
	}
	void insertionSort(int []array,int n)
	{
		int value,hole;
		
		for(int i=1;i<=n-1;i++)
		{
			value=array[i];
			hole=i;
			while(hole>0&&array[hole-1]>value)
			{
				array[hole]=array[hole-1];
				hole=hole-1;	
			}
			array[hole]=value;
			
		}
	}
	
	void mergeSort(int array[],int n)
	{
		
		if(n<2)
		{
			return;
		}
		int mid = n/2;
		int [] left =new int[mid];
	    int [] right=new int[n-mid];
		for(int i=0;i<mid-1;i++)
		{
			left[i]=array[i];
			
		}
		for(int i=mid;i<n-1;i++)
		{
			right[i-mid]=array[i];		
		}
		mergeSort(left, mid);
		mergeSort(right, mid-1);	
		merge(left, right, array);
		
	}
	
	int findMissingElement(int[] array)
 	{
        boolean integers[] = new boolean[Integer.MAX_VALUE];
        for(int i = 0;i<array.length;i++)
        {
        	   integers[array[i]]=true;
        }
        int missing_number=0;
        for(int j = 1;j<integers.length;j++)
        {
        	  if(integers[j]==false)
        	  {
        		  missing_number =j+1;
        		  break;
        	  }
        }
        return missing_number;
	}
    void merge(int[] leftArray,int[] rightArray,int []newArray)
    {
    	  int i=0 ,j=0,k=0;
    	  int l = leftArray.length;
    	  int r=rightArray.length;
    	  
    	  while(i<l && j<r)
    	  {
    		  if(leftArray[i]<rightArray[j])
    		  {
    			newArray[k++]=leftArray[i];
    					i++;
    		  }
    		  else
    		  {
    			  newArray[k++]=rightArray[j];
    			  j++;
    		  }
    	  }
    	  while(i<l)
    	  {
    		  newArray[k++]=leftArray[i++];    		  
    	  }
    	  while(j<r)
    	  {
    		  newArray[k++]=rightArray[j++]; 
    	  }
    }
   void quickSort(int[] array,int start,int end)
   {
	
	    if(start<end)
	    {
	    	  int pIndex =partition(array,start,end);
	    	  quickSort(array, start, pIndex-1);
	    	  quickSort(array, pIndex+1, end);
	    			  
	    }
   }
private int partition(int[] array, int start, int end)
{
	// TODO Auto-generated method stub
	int pivot = array[end];
	int pIndex = start;
	for(int i=start;i<=end-1;i++)
	{
		if(array[i]<=pivot)
		{
			//swap(array,i,pIndex);
			int temp = array[i];
			array[i]=array[pIndex];
			array[pIndex]=temp;
			pIndex=pIndex+1;
		}
		
	}
	int temp = array[pIndex];
	array[pIndex]=array[end];
	array[end]=temp;
	return pIndex;
}
 
}
