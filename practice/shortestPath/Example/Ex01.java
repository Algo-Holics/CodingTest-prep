package chapter07_ShortestPath;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Vertex, Edge
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int start = sc.nextInt();
		
		Graph g = new Graph(V);
		for(int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			
			g.input(x, y, w);
		}
		
		g.dijkstra(start);
		g.print();		
	}
}


class Graph{
	private int n;
	private int maps[][];
	private int distance[];
	private boolean visited[];
	
	public Graph(int n) {
		this.n = n;
		maps = new int[n+1][n+1];
	}
	
	public void input(int x, int y , int w) {
		maps[x][y] = w;
		maps[y][x] = w;
	}
	
	public int getSmallestIdx() {
		int min_val = Integer.MAX_VALUE;
		int idx = -1;
		
		for(int i = 1; i < n+1; i++) {
			if(!visited[i] && distance[i]!= Integer.MAX_VALUE) {
				if(min_val > distance[i]) {
					min_val = distance[i];
					idx = i;
				}
			}
		}
		return idx;
	}
	
	public void dijkstra(int v) {
		this.distance = new int[n+1];
		visited = new boolean[n+1];
		
		//distance 값 초기화
		for(int i = 1 ; i < n+1; i ++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		//시작 노드 값 초기화
		distance[v] = 0;
		visited[v] = true;
		
		//연결 노드 distance 갱신 (해당 노드를 방문하지 않았고, 자기자신이 아닌 경우에만)
		for(int i = 1; i < n-1; i++) {
			if(!visited[i] && maps[v][i]!=0)
			distance[i] = maps[v][i]; 
		}
		
		//n-1 회만 반복해서 확인하면 됨. (= 모든 노드를 방문한 경우)
		for(int i = 0; i < n-1; i++) {
			int now = getSmallestIdx();
			visited[now] = true;
			
			for(int j = 1; j < n+1; j++) {
				if(!visited[j] && maps[now][j]!=0) {
					int count = distance[now] + maps[now][j];
					if(count<distance[j]) {
						distance[j] = count;
					}
				}
			}
		}
	}
	
	public void print() {
		for(int i=1;i<n+1;i++){
            System.out.println(distance[i]);
        }
	}
}


/*

[TC]
 
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