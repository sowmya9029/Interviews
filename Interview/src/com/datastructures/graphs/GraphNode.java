package com.datastructures.graphs;

import java.util.ArrayList;

public class GraphNode {
	int vertice;
	public int getVertice() {
		return vertice;
	}
	public void setVertice(int vertice) {
		this.vertice = vertice;
	}
	public boolean isMark() {
		return mark;
	}
	public void setMark(boolean mark) {
		this.mark = mark;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public long getSetStartTime() {
		return setStartTime;
	}
	public void setSetStartTime(long setStartTime) {
		this.setStartTime = setStartTime;
	}
	public long getSetEndTime() {
		return setEndTime;
	}
	public void setSetEndTime(long setEndTime) {
		this.setEndTime = setEndTime;
	}
	boolean mark;
	int parent;
	int distance;
	long setStartTime;
	long setEndTime;
	ArrayList<Edge> outGoingEdge ;
	public GraphNode(int vertice,boolean mark) 
	{
		this.vertice=vertice;
		this.mark=mark;
		outGoingEdge = new ArrayList<Edge>();
	}
	public ArrayList<Edge> getOutGoingEdge() {
		return outGoingEdge;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj!=null && (obj instanceof GraphNode))
		{
			return ((GraphNode) obj).getVertice() == this.getVertice();
		}
		else
		{
			return false;
		}
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 100+this.getVertice();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "vertex : " + vertice + " " + mark + " " + parent + " " + setStartTime + " " + setEndTime;
	}
}
