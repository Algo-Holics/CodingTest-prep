package chapter08_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex04 {
	public static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		parent = new int[v+1];

		List <Node> edges = new ArrayList<Node>();
		int result = 0;
		
		initializeParent();
		
		for(int i = 0; i < e; i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			edges.add(new Node(cost, a, b));
		}
		
		Collections.sort(edges);
		
		for(int i = 0; i < edges.size(); i++) {
			int a = edges.get(i).getA();
			int b = edges.get(i).getB();
			int cost = edges.get(i).getCost();
			
			if(findRoot(a) != findRoot(b)) {
				unionParent(a, b);
				result += cost;
			}
		}
		
		System.out.println(result);
	}
	
	private static void unionParent(int a, int b) {
		a = findRoot(a);
		b = findRoot(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
	
	private static int findRoot(int v) {
		if (parent[v] != v) {
			parent[v] = findRoot(parent[v]);
		}
		return parent[v];
	}
	
	private static void initializeParent() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
}

class Node implements Comparable<Node>{
	private int cost;
	private int a;
	private int b;
	
	public Node(int cost, int a, int b) {
		this.cost = cost;
		this.a = a;
		this.b = b;
	}

	public int getCost() {
		return this.cost;
	}
	public int getA() {
		return this.a;
	}
	public int getB() {
		return this.b;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
}

