package com.datastructure.array;

public class ArrayMain 
{
  public static void main(String []args)
  {
	  Array arrayObj = new Array();
	 // int array [][]= {{1,2,3},{7,9,6},{2,1,3},{5,6,0}};	 
	 // int array1 []= {1,0,-5,7,3,2};
	  int array1 []= {-2,-4,-2,-5,-1,-2};
//	  int array1 []= {1,2,4};
//	  int array[]= {7,13,2,5,1};
//	  int twoDimArray[][]= {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
	  //arrayObj.setColRowToZero(array);
	  System.out.println(arrayObj.largestSum(array1));
//	 arrayObj.printSpiral(twoDimArray);
	 
	 // System.out.println(arrayObj.pairWithSum(array, 15));
	//  arrayObj.leader(array);
  }
}
