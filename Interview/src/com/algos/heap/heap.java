package com.algos.heap;

public class heap {

	int heapifysize;
	void heapify(int [] array,int i)
	{
		int large =i;
		int left =2*i+1;
		int right =2*i+1;
		int 	heapsize=array.length;
		if(large<heapsize && array[large]<array[left])
		{
			large=left;
		}
		if(large<heapsize &&array[large]<array[right])
		{
			large=right;
		}
		if(i!=large)
		{
			//swap (large,i);
			//swap 
			heapify(array,large);
		}
	}
	//time complexity log(n)
	//insert is done from bottom of the tree so we have to compare with the parent and percolate up.
	public void insert(int data,int array[])
	{
		int i;
       if(heapifysize==array.length)
       {
    	      resizeHeap(array);    	      
       }
       heapifysize++;
       i=heapifysize-1;
       //parent of i is at index (i-1)/2
       while(i>0 && data>array[(i-1)/2])
       {
    	       array[i]=array[(i-1)/2];
    	       i=(i-1)/2;
       }
       array[i]=data;
	}
	void resizeHeap (int array[])
	{
		int[]  tempArray = new int[array.length*2];
		for(int i =0;i<array.length;i++)
		{
			tempArray[i]=array[i];
		}
		array=tempArray;
	}
	void constructMaxHeap(int [] array)
	{
		 heapifysize =array.length;
		for(int i=heapifysize/2;i>=0;i--)
		{
			heapify(array,i);
		}
	}
	public int deleteAnElementInHeap(int array[])
	{
	   int temp;	  
	   temp = array[0];
	   array[0]=array[heapifysize];
	   array[heapifysize]=temp;
	   heapifysize--;
	   heapify(array,0);
	   return temp;
	}
	
	int kthLargerstElement(int k,int[] array)
	{
		for(int i=0;i<k-1;i++)
		{
		  	deleteAnElementInHeap(array);
		}
		return deleteAnElementInHeap(array);
	}

	int heightTree(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		return 1+Math.max(heightTree(root.right),heightTree(root.right));
	}
	Node insertInTree(Node root,int data)
	{
		if(root==null)
		{
			root = new Node(data);
		}
		else if(root.data<data)
		{
			root.right = insertInTree(root.right, data);
		}
		else
		{
			root.left = insertInTree(root.left, data);
		}
		return root;
	}

	void deleteFromTree(Node root,int data)
	{
		Node temp;
		temp=root;
		while(temp!=null)
		{
			if(temp.data<data)
			{
				temp=temp.right;
			}
			else if(temp.data>data)
			{
				temp =temp.left;
			}
			else
			{

				//temp=
			}
		}
	}
	//swap with top most element that with the nth element and reduce heapsize
	void HeapSort(int[]a ,int n)
	{
		constructMaxHeap(a);
		heapifysize = a.length;
		int temp;
		for(int i=n-1;i>0;i--)
		{
			temp=a[0];
			a[0]=a[heapifysize-1];
			a[heapifysize-1]=temp;
			heapifysize--;
			heapify(a,0);
		}
	}
    public void insert(int value) {

        if (heapSize == data.length)

            throw new HeapException("Heap's underlying storage is overflow");

        else {

            heapSize++;

            data[heapSize - 1] = value;

            siftUp(heapSize - 1);

        }

    }

    private void siftUp(int nodeIndex) {

        int parentIndex, tmp;

        if (nodeIndex != 0) {

            parentIndex = getParentIndex(nodeIndex);

            if (data[parentIndex] > data[nodeIndex]) {

                tmp = data[parentIndex];

                data[parentIndex] = data[nodeIndex];

                data[nodeIndex] = tmp;

                siftUp(parentIndex);

            }

        }

    }
}
