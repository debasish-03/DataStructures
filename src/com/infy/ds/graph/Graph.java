package com.infy.ds.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges: ");
		int v = scan.nextInt();
		int e = scan.nextInt();
		
		Graph graph = new Graph(v);
		System.out.println("Enter "+ e +" edges:");
		for(int i=0; i<e; i++) {
			int source = scan.nextInt();
			int destinition = scan.nextInt();
			graph.addEdge(source, destinition);
		}
		
		graph.printGraph();
		System.out.println();
		System.out.println("Enter source and destinition: ");
		int source = scan.nextInt();
		int destinition = scan.nextInt();
		System.out.println("Shortest distance: "+ graph.bfs(source,  destinition));
		
	}
	
	//Graph implementation using linked list
	private LinkedList<Integer>[] adj;  // adjacency lists
	public Graph(int v) {
		adj = new LinkedList[v]; //vertices of graph
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int destinition) {
		adj[source].add(destinition);
		adj[destinition].add(source);
	}
	public void printGraph()
    {
        for (int i = 0; i < adj.length; i++) {
            System.out.println("\nAdjacency list of vertex"
                               + i);
            System.out.print("head");
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(" -> "
                                 + adj[i].get(j));
            }
            System.out.println();
        }
    }
	
	public int bfs(int source, int distinition) { // BFS(Breadth for search) helps to find shortest path
		
		boolean[] visited = new boolean[adj.length];
		int[] parent = new int[adj.length];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		parent[source] = -1;
		visited[source] = true;
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(curr == distinition)
				break;
			
			for(int neighbour: adj[curr]) {
				if(!visited[neighbour]) {
					visited[neighbour] = true;
					queue.add(neighbour);
					parent[neighbour] = curr;
				}
			}
		}
		
		int curr = distinition;
		int distance = 0;
		while(parent[curr] != -1) {
			System.out.print(curr+" -> ");
			curr = parent[curr];
			distance++;
		}
		System.out.print(curr+" -> ");
		return distance;
	}

}
