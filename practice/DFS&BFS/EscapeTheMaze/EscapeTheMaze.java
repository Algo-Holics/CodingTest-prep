package chapter03_dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EscapeTheMaze {
	public static int[][] maze;
	public static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		maze = new int[n][m];
		
		sc.nextLine();
		
		for(int i = 0; i< n; i++) {
			String temp = sc.nextLine();
			for(int j = 0; j < m ; j++) {
				maze[i][j] = temp.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0, 0));
	}
	
	public static int bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(r, c));

		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			r = node.getIdx();
			c = node.getDistance();
			
			for(int i = 0; i< 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];
				
				if(nx<0 || ny<0 || nx>= n|| ny>=m || maze[nx][ny] =='0' ) {
					continue;
				}
				
				if(maze[nx][ny] == 1) {
					maze[nx][ny] = maze[r][c] + 1;
					queue.add(new Node(nx, ny));
				}
			}
		}
		
		return maze[n-1][m-1];
	}
}

class Node{
	private int idx;
	private int distance;

	public Node(int idx, int distance) {
		this.idx = idx;
		this.distance = distance;
	}
	//getter
	public int getIdx() {
		return this.idx;
	}
	public int getDistance() {
		return this.distance;
	}
}
