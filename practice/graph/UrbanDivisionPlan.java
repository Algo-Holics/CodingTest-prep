package chapter08_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UrbanDivisionPlan {
	public static int[] parent;
	public static int result, maxEdge;
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		//N: vertex, M: edge 
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N + 1];
		result = 0;
		maxEdge = Integer.MIN_VALUE;
		
		intializeParent();
		List <Edge> edges = new ArrayList<Edge>();
		
		for(int i = 0 ; i < M; i++) {
			int nodeA = sc.nextInt();
			int nodeB = sc.nextInt();
			int cost=  sc.nextInt();
			
			edges.add(new Edge(nodeA, nodeB, cost));
		}
		
		Collections.sort(edges);
		
		for(int i = 0; i < edges.size(); i++) {
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			int cost = edges.get(i).getCost();
			
			if(findRoot(a)!= findRoot(b)) {
				unionParent(a, b);
				result += cost;
				if(maxEdge <cost) {
					maxEdge = cost;
				}
			}
		}
		
		result -= maxEdge;
		
		System.out.println(result);
	}
	
	private static void unionParent(int a, int b) {
		a = findRoot(a);
		b = findRoot(b);
		
		if(a > b) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
	}

	private static int findRoot(int v) {
		if(v != parent[v]) {
			return findRoot(parent[v]);
		}
		return parent[v];
	}

	private static void intializeParent() {
		for(int i = 1; i < parent.length ; i++) {
			parent[i] = i;
		}
	}

}

class Edge implements Comparable<Edge>{
	private int nodeA;
	private int nodeB;
	private int cost;
	
	public Edge(int nodeA, int nodeB, int cost) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.cost = cost;
	}
	
	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	public int getCost() {
		return cost;
	}

	//cost 순 오름차
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

