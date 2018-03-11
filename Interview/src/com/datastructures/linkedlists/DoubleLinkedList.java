package com.datastructures.linkedlists;

public class DoubleLinkedList {
	DoubleLinkedListNode head=null;
	
	void insertAtHead(String data)
	{
		DoubleLinkedListNode newNode;
		//System.out.println(head);
		if(head==null)
		{
			head = new DoubleLinkedListNode(data);			
		}
		else 
		{
			
			newNode = new DoubleLinkedListNode(data);
			head.prev=newNode;
			newNode.next=head;			
			newNode.prev=null;
			head=newNode;
		}     
		
	}
	void delete(String key) 
	{
		DoubleLinkedListNode temp = null;
		temp=head;				
		while(!temp.next.data.equals(key))
		{
			temp=temp.next;
		}
		System.out.println("--"+temp.data);
		DoubleLinkedListNode keyNode = temp.next;
		temp.next=temp.next.next;
		temp.next.prev=temp;
		keyNode = null;
		System.out.println("-- temp next "+temp.next.data);
		System.out.println("-- temp next prev "+temp.next.prev.data);
//		System.out.println("--"+temp.next.data);
//		System.out.println("--"+temp.next.data);
	}
	
	
	void deleteAtHead() 
	{
		DoubleLinkedListNode temp;	
		temp=head;
		if(temp!=null)
		{
			head =temp.next;
			temp=null;
			head.prev=null;
		}		
	}
	void insertBefore(String key, String data) {
		DoubleLinkedListNode temp;
		DoubleLinkedListNode newNode;
		//SingleLinkedListNode insertPosition = new SingleLinkedListNode(key);
		//head = new DoubleLinkedListNode(data);	
		temp=head;
		
		while(temp.next!=null&&!temp.next.data.equals(key))
		{
			
			temp=temp.next;
			
		}
		
		newNode=new DoubleLinkedListNode(data);
		newNode.next=temp.next;
		temp.next=newNode;
		newNode.prev=temp;
	//	temp.next.prev=newNode;
		
	//	newNode.prev=temp;
		
	}
	void insertAtTail(String data)
	{
		DoubleLinkedListNode newNode= new DoubleLinkedListNode(data);
		DoubleLinkedListNode temp;
		if(head==null)
		{
			head = new DoubleLinkedListNode(data);			
		}
		else
		{
		temp = head ;		
		while(temp.next!=null)
		{
			 temp=temp.next;
		}
        temp.next=newNode;
        newNode.prev = temp;
        newNode.next=null;
		}
	}
	void print()
	{
		DoubleLinkedListNode temp;
		temp=head;	
		
		while(temp!=null)
		{	
			System.out.println(temp.data);
			temp =temp.next;
		}

	} 


}
