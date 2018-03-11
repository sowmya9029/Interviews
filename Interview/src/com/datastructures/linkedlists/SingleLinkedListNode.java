package com.datastructures.linkedlists;

public class SingleLinkedListNode {
	String data;
	SingleLinkedListNode next;
	public SingleLinkedListNode(String data)
	{
		this.data=data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public SingleLinkedListNode getNext() {
		return next;
	}
	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.data;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		return data.length();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null &&obj instanceof SingleLinkedListNode) {
			return this.data.equals(((SingleLinkedListNode)obj).data);
		}
		return false;
	}
	

}
