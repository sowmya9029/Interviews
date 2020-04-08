package com.datastructures.linkedlists;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SingleLinkedList {
	public static SingleLinkedListNode head;
	private SingleLinkedListNode2 head1;
	void insertAtHead(String data)
	{
		SingleLinkedListNode newNode;

		if(head==null)
		{
			head=new SingleLinkedListNode(data);	   			
		}
		else
		{
			newNode = new SingleLinkedListNode(data);
			newNode.setNext(head);
			head=newNode;
		}
	}

	void insertAtEnd(String data)
	{
		SingleLinkedListNode newNode;
		SingleLinkedListNode temp;
		newNode = new SingleLinkedListNode(data);
		temp=head;
		while(temp.getNext()!=null)
		{
			temp =temp.getNext();
		}
		temp.setNext(newNode);		
	} 

	/**
	 * search for the key in list and insert data before the key.
	 * @param data
	 */
	void insertBefore(String key, String data) {
		SingleLinkedListNode temp;
		SingleLinkedListNode newNode;
		//SingleLinkedListNode insertPosition = new SingleLinkedListNode(key);
		temp=head;				
		while(!temp.getNext().getData().equals(key))
		{
			temp=temp.getNext();
		}
		newNode=new SingleLinkedListNode(data);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
	}


	void tamperList()
	{
		SingleLinkedListNode temp;
		temp=head;
		//System.out.println(temp);
		while(temp.next!=null)
		{				
			temp =temp.getNext();
		}		
		temp.next=head.next.next;
	}

	void print()
	{
		SingleLinkedListNode temp;
		temp=head;
		//System.out.println(temp);
		while(temp!=null)
		{	
			System.out.println(temp.getData());
			temp =temp.getNext();
		}

	} 
	void print(SingleLinkedListNode node)
	{
		SingleLinkedListNode temp;
		temp=node;
		//System.out.println(temp);
		while(temp!=null)
		{	
			System.out.println(temp.getData());
			temp =temp.getNext();
		}

	} 

	void delete(String key) 
	{
		SingleLinkedListNode temp;
		SingleLinkedListNode newNode;
		//SingleLinkedListNode insertPosition = new SingleLinkedListNode(key);
		temp=head;				
		while(!temp.getNext().getData().equals(key))
		{
			temp=temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());	
		temp.getNext().setNext(null);
		//temp.setNext(null);
	}

	void deleteAtHead() 
	{
		SingleLinkedListNode temp;
		temp=head;
		if(temp!=null)
		{
			head =temp.getNext();
			temp=null;
		}		
	}

	void reverseList()
	{
		SingleLinkedListNode current,temp_next,prev;
		current=head;
		prev=null;
		while(current!=null)
		{
			temp_next=current.next;
		    current.next=prev;
			prev = current;
			current = temp_next;
		}
           head = prev;
	}
	//tortoise and hare
	SingleLinkedListNode reverseFromMiddleList(SingleLinkedListNode middle)
	{
		SingleLinkedListNode current,temp,temp1,nodeBeforeMiddle;
		nodeBeforeMiddle=head;
		//go little the middle of the node
		while(nodeBeforeMiddle.next!=middle)
		{
			nodeBeforeMiddle=nodeBeforeMiddle.next;
		}

		//reverse from the middle
		current=middle;
		temp=current.next;
		temp1=temp.next;
		current.next=null;

		while(temp1!=null)
		{
			temp.next=current;
			current=temp;
			temp=temp1;
			temp1=temp.next;
		}
		temp.next=current;

		//link middle next to the reversed list
		nodeBeforeMiddle.next=temp;
		return head;		 		 		 
	}
	SingleLinkedListNode findMiddleOfList()
	{
		SingleLinkedListNode fast,slow;	
		if(head==null)
		{
			return null;
		}
		if(head.next!=null)
		{
			slow=head;
			fast=head;
			while(fast!=null&&fast.next!=null)
			{
				slow=slow.next;
				fast=fast.next.next;						
			}
			return slow;		
		}
		else
		{
			return head;
		}


	}

	void detectAndBreak()
	{
		//tamperList();
		SingleLinkedListNode fast,slow,temp;
		slow=head;
		fast=head;

		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow)
			{
				System.out.println("Loop Detected");
				break;
			}
		}
		//if(fast==null || fast.next==null)
		//{
		//	System.out.println("Happy Ending");
		//}
		//else
		//{
			//System.out.println("Sad Ending");
			slow=head;
			while(fast!=slow)
			{
				fast=fast.next;
				slow =slow.next;
			}
			if(slow==fast)
			{
				//slow.data is the start of the loop
			}

		//}
	}
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k < 1)
			return head;

		ListNode current = head;
		int listLength = 1;

		// Find length of the list, we consider the first node as length 1
		while(current.next != null)
		{
			listLength ++;
			current = current.next;
		}

		// Calculate the real rotate distnace from the head to the rotation head
		int realRotate = listLength - (k % listLength);

		// Create cycle
		current.next = head;

		// Move head
		for(int i = 0; i < realRotate; i ++)
		{
			head = head.next;
			current = current.next;
		}

		current.next = null;
		return head;
	}
	void deleteAtTail() 
	{
		SingleLinkedListNode temp;
		temp=head;
		while(temp.getNext().getNext()!=null)
		{
			temp = temp.getNext();
			//temp=null;
		}
		temp.setNext(null);
	}

	//duplicate element in list
	void removeDuplicateElement()
	{
		SingleLinkedListNode temp,temp1;
		temp=head;
		while(temp.next!=null)
		{						
			temp1=temp.next;
			while(temp1.next!=null)
			{
				if(temp.data.equalsIgnoreCase(temp1.next.data))
				{
					System.out.println("same"+temp1.data);
					temp1.next=temp1.next.next;
					//delete(temp1.data);
				}
				temp1=temp1.next;
			}
			temp=temp.next;

		}

	}
	125
	 25 150

	//5->2->1 ->null
	//5-2->null
	//result -> 0->5->1->null
	//sumOf 2linked list
	//SingleLinkedListNode result = ;
	public void sumOfTwoLinkedList(SingleLinkedListNode node1,SingleLinkedListNode node2,SingleLinkedList res,int carry)
	{
		int a=0;
		int b = 0;

		if(node1==null&&node2==null)
		{
			if(carry>0)
			{
				res.insertAtEnd(carry);
			}
			return;
		}
		else if(node2==null)
		{

			a=Integer.parseInt(node1.data);
			b=0;
		}
		else if(node1==null)
		{

			a=0;
			b=Integer.parseInt(node2.data);
		}
		else 
		{
			a=Integer.parseInt(node1.data);
			b=Integer.parseInt(node2.data);

		}
		int sum=a+b+carry;
		carry=sum/10;
		res.insertAtEnd(sum%10);

		sumOfTwoLinkedList(node1.next,node2.next,res,carry);
		//PriorityQueue q = new P
		// return  res;
	}

	//duplicate element in list
	void removeDuplicateElementUsingHash()
	{
		HashSet<SingleLinkedListNode> set = new HashSet<SingleLinkedListNode>();
		SingleLinkedListNode temp;
		temp=head;
		set.add(temp);
		while(temp!=null)
		{
			temp=temp.next;				
			if(!set.contains(temp))
			{
				set.add(temp);
			}				
		}
		System.out.println();			
	}


	void kthElement(String key)
	{
		SingleLinkedListNode temp;temp=head;
		while(!temp.data.equalsIgnoreCase(key))
		{
			temp=temp.next;
		}

		while(temp!=null)
		{	
			System.out.println(temp.data);
			temp =temp.next;
		}

	}

	void sortListBasedOnKey(String key)
	{
		SingleLinkedListNode temp,temp1 = null,temp2;
		String temp_data;
		temp=head;		

		// temp1=head;
		while(temp.next!=null)
		{	
			if(temp.data.equalsIgnoreCase(key))
			{
				temp1=temp;
			}
			temp=temp.next;
		}

		//swap with last element
		temp_data=temp.data;
		temp.data=temp1.data;
		temp1.data=temp_data;


		temp2=head;
		while (temp2.next!=null&&temp2!=temp1)
		{
			if(Integer.parseInt(temp2.data)>Integer.parseInt(temp1.data))
			{

				//temp1.next=temp2;
			}
			else
			{
				//temp2=temp2.next;
			}
		}
		//		
	}

	int countNodes(SingleLinkedListNode head)
	{
		int count = 0;
		SingleLinkedListNode temp = head;
		while (temp != null)
		{
			temp = temp.next;
			count++;
		}
		return count;
	}

	SingleLinkedListNode2 node;
	boolean temp=false;


	public boolean isPalindrome(SingleLinkedListNode2 head) {
		node = head;     
		if(head==null)
		{
			return true;
		}
		temp = isPalindrome(head.next); 
		if (temp == false)
			return false;     
		if(head.data == node.data)
		{
			temp = true;
		}      
		node = node.next;
		return temp;      
	}

	void insertAtEnd(int data)
	{
		SingleLinkedListNode2 newNode;
		SingleLinkedListNode2 temp;
		newNode = new SingleLinkedListNode2(data);
		if(head1==null)
		{
			head1=new SingleLinkedListNode2(data);	   			
		}
		else
		{
			temp=head1;
			while(temp.next!=null)
			{
				temp =temp.next;
			}
			temp.next=newNode;	
		}
	} 
	void sumOfTwoList(SingleLinkedList linkedList1,SingleLinkedList linkedList2)
	{


	}

}
