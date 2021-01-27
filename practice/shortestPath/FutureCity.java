package chapter07_ShortestPath;

import java.util.Scanner;

public class FutureCity {
	public static int INF = (int) (1e9);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int graph[][] = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				graph[i][j] = INF;
				if (i == j) {
					graph[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		for (int i = 1; i < n + 1; i++) {
			for (int a = 1; a < n + 1; a++) {
				for (int b = 1; b < n + 1; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
				}
			}
		}
		
		int x = sc.nextInt();
		int k = sc.nextInt();
		
		if(graph[1][k] == INF || graph[k][x] == INF) {
			System.out.println(-1);
		}else {
			System.out.println(graph[1][k] + graph[k][x]);
		}
		
	}

}



/*
[TC1]
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

[TC2]
4 2
1 3
2 4
3 4

앞에 Example을 오래 봐서 플로이드 워셜 알고리즘인걸 바로 알았다; 그래서 바로 구현 할 수 있었다. 
(간선에 대한 비중이 없어서 1로 담아주고, 양방향인 점만 Ex03에서 수정해서 해결 가능했다.)

 */
