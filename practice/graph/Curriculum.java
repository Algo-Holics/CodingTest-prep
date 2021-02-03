package chapter08_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] inDegree, time;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		inDegree = new int[N+1];
		time = new int[N+1];
		
		//graph초기화
		for(int i = 0 ; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
			while(true) {
				//x: 선행학습
				int x = sc.nextInt();
				if(x == -1) break;
				//선행해야하는 학습이 있을때마다, 해당과목(i)는 진입차수가 증가함.
				inDegree[i]++;
				//x -> i
				graph.get(x).add(i);
			}
		}
		
		topologySort();
	}

	private static void topologySort() {
		int result[] = new int[time.length];
		System.arraycopy(time, 0, result, 0, time.length);
		Queue <Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i < inDegree.length; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i : graph.get(now)) {
				result[i] = Math.max(result[i], time[i] + result[now]);
				inDegree[i]--;
				if(inDegree[i] == 0) {
					q.add(i);
				}
			}
		}
		
		for(int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}

/*

[제일 이해가 안갔던 부분]
1. 왜 최소 시간인데, result에 max로 담는건지
	이유: 선수과목 모두 들어야 그 다음 과목을 들을 수 있기 때문에, 동시에 선수과목을 들을 수 있는게 가능하다는 전제하에
	선수 과목들 중 가장 긴 과목시간이 최소 걸린 시간이기 때문이다.

2. graph.get(x).add(i)
	방향이 x->i 엄청 헷갈렸다..;; 왜지..
	
3. 이전에 Ex05에서 연습하고 푼건데도 어려웠음...(결국 참조 해야만했다..ㅠ)
 
*/
 