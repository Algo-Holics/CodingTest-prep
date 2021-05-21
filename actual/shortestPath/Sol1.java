package algo.shortestPath;

import java.util.Scanner;

//Q. 플로이드
public class Sol1 {
    public final static int INF =100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] info = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                info[i][j] = INF;
                if(i==j){
                    info[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            info[x][y] = Math.min(w, info[x][y]);           //노선이 하나가 아니다 매 순간 작은 노선으로 업데이트 해서 담기
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    info[a][b] = Math.min(info[a][b], info[a][k] + info[k][b]);
                }
            }
        }

        //출력시 I/O 적게 하려고 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j<= n; j++){
                if(info[i][j] == INF) {
                    sb.append("0 ");
                }else{
                    sb.append(info[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
/*
https://www.acmicpc.net/problem/11404
 */