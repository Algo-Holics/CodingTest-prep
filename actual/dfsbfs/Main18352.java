package algo.dfsbfs;

import java.util.*;

public class Main18352 {
    // bfs 로 풀릴수 있었던 이유
    // 1. 간선 비중(weight) 이 모두 1 이다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 도시
        int M = sc.nextInt();   // 도로
        int K = sc.nextInt();   // 거리 정보
        int X = sc.nextInt();   // 출발 노드

        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int[] distance = new int[N+1];

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        distance[X] = 0;

        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.get(x).add(y);
        }

        //queue 로 bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        while(!q.isEmpty()){
            int prev = q.poll();
            for(int cur: list.get(prev)){
                // 현재 노드가 방문한 적이 없는 노드라면, 이전에 방문노드에 + 1 (최단거리 업데이트)
                if(distance[cur] == -1){
                    distance[cur] = distance[prev] + 1;
                    q.add(cur);
                }
            }
        }

        // 거리가 K인 노드 출력 (노드를 출력하는거!)
        boolean flag = false;
        for(int i = 1; i <= N; i++){
            if(distance[i] == K){
                System.out.println(i);
                flag = true;
            }
        }
        //해당하는 거리 없으면 -1 출력
        if(!flag){
            System.out.println(-1);
        }
    }
}
