package chap4;

import java.util.HashMap;
import java.util.Map;

public class Graph {
	public static HashMap<Integer, GraphNode> graph;
	
	public Graph() {
		graph = new HashMap<Integer, GraphNode>();
	}
	
	public static void addNode(int node){
		graph.put(node, new GraphNode(node));
	}
	
	public static void addNeighbour(int node, int neighbour) {
		graph.get(node).neighbours.add(neighbour);
	}
	
	public void display() {
		
		for (Map.Entry<Integer,GraphNode> entry : graph.entrySet()) {
			  GraphNode value = entry.getValue();	
			  System.out.print(value.data + " : " );
			  value.printNeighbours();
			}		
	}
	
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(4);
		graph.addNode(3);
		graph.addNeighbour(1,2);
		graph.addNeighbour(1,3);
		graph.addNeighbour(2,1);
		graph.addNeighbour(2,4);
		graph.addNeighbour(3,1);

		graph.display();
	}

}
