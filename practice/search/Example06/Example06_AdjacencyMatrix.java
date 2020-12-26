package chapter03_dfsbfs;

import java.util.Arrays;

public class Example06_AdjacencyMatrix {
	public static void main(String[] args) {
		//Adjacency Matrix (인접행렬)
		//2차원 배열로 그래프 연결관계 표현
		final int INF = Integer.MAX_VALUE;
		
		int graph[][] = {
							{0, 7, 5}, 
							{7, 0, INF}, 
							{5, INF, 0}
						};
		
		for(int[] g : graph) {
			System.out.print(Arrays.toString(g));
		}
	}
}
