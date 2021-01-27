package chapter07_ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Telegram {
	public static final int INF = (int) 1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);
        
        dijkstra(start);
        
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < d.length; i++) {
        	if(d[i]!=INF) {
        		cnt++;
        		max = Math.max(max, d[i]);
        	}
        }
        
        System.out.println((cnt -1) + " " + max);
	}
	public static void dijkstra(int start) {
		Queue <Node> pq = new PriorityQueue<Node>();
		
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int dist = node.getDistance();
			int now  = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
		
	}
}

class Node implements Comparable<Node>{
	public int index;
	public int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node o) {
		return this.distance - o.distance;
	}
}