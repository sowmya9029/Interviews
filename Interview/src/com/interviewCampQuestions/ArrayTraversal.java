package com.interviewCampQuestions;

public class ArrayTraversal
{

   static void dutchNationalFlag(int a[] , int i)
    {
        int pIndex = 0;
        int end = a.length-1;
        swap(a,i,end);
        int pivot = a[end];
        for(int j=0;j<end;j++)
        {
           if(a[j]<=pivot)
           {
               swap(a,j,pIndex);
               pIndex++;
           }
           swap(a,end,pIndex);
        }
        System.out.println(a);
    }
    static void swap(int array[],int i,int end)
    {
        int temp;
        temp = array[i];
        array[end] = temp;
        array[i] = array[end];
    }

    public static void main(String args[])
    {
        int a[] = {3,5,2,6,8,4,4,6,4,4,3};
        dutchNationalFlag(a,5);
    }
}
