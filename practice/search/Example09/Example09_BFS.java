package chapter03_dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Example09_BFS {
	static boolean [] visited = new boolean[9];
	static int graph [][] = {
			{},
			{2, 3, 8},
			{1, 7},
			{1, 4, 5},
			{3, 5},
			{3, 4},
			{7},
			{2, 6, 8},
			{1, 7}
	};
	public static void main(String[] args) {
		bfs(1);
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			System.out.print(v +" ");
			for(int i : graph[v]) {
				if (visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
