//package com.datastructures.stack;
//
//public class Stack {
//	static int head=0;
//	static int stack[] = new int[10];
//	static int temp_stack[];
//	public static void main(String[] args)
//	{
//		//printStack();
//        push(1);
//        push(2);
//		push(3);
//        push(4);
//        push(5);
//        push(6);
//        push(7);
//        push(8);
//        push(9);
//        push(10);
//        push(11);
//        push(12);
//        pop();
//        pop();
//       printStack();
//
//	}
//	static void push(int ele)
//	{
//
//		if(head==stack.length)
//		{
//			temp_stack = new int[(stack.length)*2];
//			for (int i = 0; i<stack.length ; i++) {
//
//				temp_stack[i] = stack[i];
//
//			}
//			temp_stack[head++]=ele;
//			stack = temp_stack;
//		}
//		else
//		{
//
//			stack[head++]=ele;
//		}
//	}
//	static void printStack()
//	{
//		for (int i = 0; i <stack.length ; i++) {
//			System.out.println(stack[i]);
//		}
//	}
//	static boolean isEmpty()
//	{
//		if(stack.length!=0)
//		{
//			return false;
//		}
//		else
//		{
//			return true;
//		}
//	}
//
//	static void pop()
//	{
//		if(!isEmpty())
//		{
//
//	        stack[head-1] = 0;
//	        head--;
//
//		}
//		else
//		{
//			head=0;
//
//		}
//	}
//	static int peek()
//	{
//		if (!isEmpty())
//			return stack[stack.length-1];
//		else
//			return 0;
//	}
//
//
//	/* prints element and NGE pair for
//     all elements of arr[] of size n */
//	static void printNGE(int arr[], int n)
//	{
//		Stack s = new Stack();
//		int next = -1;
//		s.push(arr[0]);
//
//        for(int i=1;i<arr.length;i++)
//		{
//			next = arr[i];
//
//			while(!s.isEmpty() && s.peek()<next)
//			{
//				//if (s.isEmpty() == true)
//				  //break;
//				System.out.println(s.peek() + " --> " + next);
//				s.pop();
//			}
//			s.push(next);
//			//if (s.peek() > next)
//				//s.push(element);
//		}
//		}
//	}
//
//
//
//}
