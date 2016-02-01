package chap4;

import java.util.ArrayList;

public class GraphNode {
	public int data;
	public ArrayList<Integer> neighbours = new ArrayList<Integer>();
	
	public GraphNode(int data) {
		this.data = data;
	}
	
	public void addNeighbour(Integer neighbour) {
		neighbours.add(neighbour);
	}
	
	public void printNeighbours() {
		System.out.println(neighbours);
	}
	
}
