package com.datastructure.array;

import java.util.Arrays;

public class Array
{

    // island matrix
    static final int ROW = 5, COL = 5;
    int countIslands(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && ! visited[i][j])
                {
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }

    public int countPrimes(int n) {
        int primeCount = 0;

        if (n <= 2)
            return 0;

        int primes[] = new int[n];

        for(int i=2;i<n;i++)
        {
            primes[i] =1;
        }
        primes[0]=0;
        primes[1]=0;

        System.out.println(Math.sqrt(n));

        for(int i=2;i<= Math.sqrt(n); i++)
        {
            //System.out.println(""+primes[i]);
            if(primes[i]==1)
            {
                for(int j=2;i*j<n;j++)
                {
                    primes[i*j]=0;
                }
            }
        }
        for(int i:primes)
        {
            if(i==1)
            {
                primeCount++;
            }
        }
        return primeCount;
    }
// island matrix
    int maze(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
               // if (M[i][j] == 1 && ! visited[i][j])
                //{
                    hasPath(M, i, j, visited);
                  //  ++count;
                //}

        return count;
    }

    void DFS(int M[][], int row, int col, boolean visited[][])
    {

        if((row <= 0) && (row > ROW) &&
                (col <= 0) && (col > COL) && M[row][col]==0 && visited[row][col])
        {
            return;
        }
                 visited[row][col] = true;

                 DFS(M,row+1,col,visited);
                 DFS(M,row-1,col,visited);
                 DFS(M,row,col-1,visited);
                 DFS(M,row,col+1,visited);
    }



    int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++)
        {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++)
        {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }


  private boolean hasPath(int a[][],int row,int col, boolean visited[][])
    {
        if(row==a.length-1 && col== a.length-1)
        {
            return true;
        }

        if(a[row][col]==1 && row>=0 && row<a.length && col<a.length  && col>=0 && !visited[row][col])
        {
            visited[row][col]= true;
            hasPath(a,row+1,col,visited);
            hasPath(a,row-1,col,visited);
            hasPath(a,row,col+1,visited);
            hasPath(a,row,col-1,visited);
             visited[row][col]= false;
        }

        return false;
    }




    int largestSum(int array[])
	{
		int maxSum=array[0],runSum=array[0];
		for (int i = 1; i < array.length; i++)
		{
			runSum += array[i];
			if(runSum<0||runSum<array[i])
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
		for (int i = 0; i < array.length/2; i++)
		{
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
		Arrays.sort(array); //nlgn
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
				//System.out.println(nums[i]+"--"+len+"--"+i);
				nums[i]=nums[--len];
			}
		}
		return len;

	}
	//inplace remove element
	public int removeElementInPlace(int[] nums, int val) {
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



	public static int median(int[] arr1, int[] arr2)
	{
		int N = arr1.length;
		return median(arr1, 0, N -1 , arr2, 0, N - 1);
	}

	public static int median(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2)
	{
		int mid1 = (h1 + l1 ) / 2;
		int mid2 = (h2 + l2 ) / 2;

		if (h1 - l1 == 1)
			return (Math.max(arr1[l1] , arr2[l2]) + Math.min(arr1[h1] , arr2[h2]))/2;

		else if (arr1[mid1] > arr2[mid2])
			return median(arr1, l1, mid1 , arr2, mid2 , h2);

		else if (arr1[mid1] == arr2[mid2])
        {
            return arr1[mid1];
        }
        else{
			return median(arr1, mid1 , h1, arr2, l2 , mid2 );
        }
	}

	int median(int arr[], int n)
	{
		if (n%2 == 0)
			return (arr[n/2] + arr[n/2-1])/2;
		else
			return arr[n/2];
	}

    public static int firstOccuranceOfNumber(int[] array,int target)
    {

        return firstOccuranceOfNumber(0,array.length-1,array,target);
    }
    public static int firstOccuranceOfNumber(int low, int high , int[] array,int target)

    {
        int result = -1;
        if(low <= high ) {

            int mid = low + (high - low) / 2;
            if (target == array[mid])
            {
                result = mid;
                // System.out.println(mid);
                firstOccuranceOfNumber(low, mid - 1, array, target);
            }
            else if (target < array[mid])
            {
                firstOccuranceOfNumber(low, mid - 1, array, target);
            }
            else {
                firstOccuranceOfNumber(mid + 1, high, array, target);
            }
        }
        return result;
    }
    public static int firstOccuranceOfNumberIterative( int[] array,int target)
    {
        int low=0;
        int high = array.length-1;
        int result =-1;
        while(low<=high)
        {
            int mid = low + (high - low) / 2;

            if(array[mid]==target)
            {
                result= mid;
                high = mid-1;
            }
            else if(array[mid]<target)
            {
                low =mid+1;

            }
            else
            {
                high =mid-1;
            }
        }
        return result;
    }
    public boolean canJump(int[] A) {
        if(A.length <= 1)
            return true;

        int max = A[0]; //max stands for the largest index that can be reached.

        for(int i=0; i<A.length; i++){
            //if not enough to go to next
            if(max <= i && A[i] == 0)
                return false;

            //update max
            if(i + A[i] > max){
                max = i + A[i];
            }

            //max is enough to reach the end
            if(max >= A.length-1)
                return true;
        }

        return false;
    }
    //We are given an array arr[] of size n. Numbers are from 1 to (n-1) in random order.
 //The array has only one repetitive element. We need to find the repetitive element.
    //we also have solution of xor
    static int findRepeating(int arr[], int n)
    {
        int missingElement = 0;

        // indexing based
        for (int i = 0; i < n; i++){

            int element = arr[Math.abs(arr[i])];

            if(element < 0){
                missingElement = arr[i];
                break;
            }

            arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }

        return Math.abs(missingElement);

    }


    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 5, 4, 3, 9, 8,
                9, 1, 6, 2, 5};

        int n = arr.length;

        System.out.println(findRepeating(arr, n));

    }
}

