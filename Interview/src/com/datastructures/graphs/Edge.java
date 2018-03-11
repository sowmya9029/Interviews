package com.datastructures.graphs;

public class Edge {
int weight;
GraphNode source;
GraphNode destination;
Edge(GraphNode source,GraphNode destination,int weight)
{
	this.source=source;
	this.weight=weight;x
	this.destination=destination;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public GraphNode getSource() {
	return source;
}
public void setSource(GraphNode source) {
	this.source = source;
}
public GraphNode getDestination() {
	return destination;
}
public void setDestination(GraphNode destination) {
	this.destination = destination;
}
}
