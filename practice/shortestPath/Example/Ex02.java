package chapter07_ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Ex02 {
	public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
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

	        for (int i = 1; i <= n; i++) {
	            if (d[i] == INF) {
	                System.out.println("INFINITY");
	            }
	            else {
	                System.out.println(d[i]);
	            }
	        }
	    }
	

	public static void dijkstra(int start) {
		Queue <Node> pq = new PriorityQueue<Node>();
		
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int dist = node.getDistance();
			int now  = node.getIndex();
			
			// 이미 처리된 적이 있는 node는 넘어감. 
			// (현재 queue에서 빼낸 distance가 저장되어있는 distance보다 크면 넘어감) 
			if(d[now] < dist) continue;
			
			// 인접노드들 확인후, 갱신한 값이 작으면 변경 후 heap에 다시 넣어 줌.
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


/*

6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

*/