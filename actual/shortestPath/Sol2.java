package algo.shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class Sol2 {
    public static final int INF = 501;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j)continue;
                graph[i][j] = INF;
            }
        }

        for(int i = 0; i < m ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }

        for(int i = 0;  i < n; i++){
            System.out.println(Arrays.toString(graph[i]));
        }

        for(int k = 1; k<= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j<= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }


        int answer = 0;

        for(int i = 1; i <=n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                // A->B 혹은 B->A 길이 있는걸 알기만 해도 둘 중에 누가 더 잘했는지 성적 비교가 가능하다.
                if(graph[i][j] != INF || graph[j][i] !=INF){
                    cnt++;
                }
            }
            // 모든 방향에서 성적비교가 가능하다면 해당 학생은 성적이 비교 가능한 학생이다.
            if(cnt == n){
                answer++;
            }
        }
        System.out.println(answer);
    }
}

/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
*/