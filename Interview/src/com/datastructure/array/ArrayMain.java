//package com.datastructure.array;
//
//public class ArrayMain
//{
//  public static void main(String []args)
//  {
//	  Array arrayObj = new Array();
//	 // int array [][]= {{1,2,3},{7,9,6},{2,1,3},{5,6,0}};
//	 // int array1 []= {1,0,-5,7,3,2};
//	  int array1 []= {-2,-4,-2,-5,-1,-2};
//	  int array2 []= {0,1,1,1,1,2,2,2,4};
////	  int array[]= {7,13,2,5,1};
////	  int twoDimArray[][]= {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
//	  //arrayObj.setColRowToZero(array);
//	 // System.out.println(arrayObj.largestSum(array1));
////	 arrayObj.printSpiral(twoDimArray);
//
//	 // System.out.println(arrayObj.pairWithSum(array, 15));
//	//  arrayObj.leader(array);
//
//    /*  SampleIterable x = new SampleIterable("This is a test.");
//
//      for (char ch : x){
//          System.out.println(ch);
//      }
//
//      String[] technologies = {"Java", "JEE", "XML"};
//      MyIterable<String> entries = new MyIterable<String>(technologies);
//      for (String tech : entries) {
//          System.out.println(tech);
//      }
//*/
//      System.out.println(""+firstOccuranceOfNumber(array2,1));
//
//  }
//
//    public static int firstOccuranceOfNumber(int[] array,int target)
//    {
//        return firstOccuranceOfNumber(0,array.length-1,array,target);
//    }
//    public static int firstOccuranceOfNumber(int low, int high , int[] array,int target)
//    {
//        if(low >= high ) {
//            return -1;
//        }
//        int mid =low+(high)/2;
//
//        if(target == array[mid])
//        {
//            return mid;
//        }
//        if(target<array[mid])
//        {
//            return  firstOccuranceOfNumber(low, mid-1,array,target);
//        }
//        else
//        {
//            return  firstOccuranceOfNumber(mid+1, high,array,target);
//        }
//
//    }
//}
