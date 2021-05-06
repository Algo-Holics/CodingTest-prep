package algo.dp;

import java.util.Scanner;

//Main1932
public class Solution1 {
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 0; t < T; t++){
            n = sc.nextInt();
            m = sc.nextInt();

            dp = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = sc.nextInt();
                }
            }

            for(int i = 1; i < m; i++){
                for(int j = 0; j < n ; j++){
                    int left, leftUp, leftDown;

                    if(j == 0) leftUp = 0;
                    else leftUp = dp[j-1][i-1];

                    if(j == n-1) leftDown = 0;
                    else leftDown = dp[j+1][i-1];

                    left = dp[j][i-1];

                    dp[j][i] += Math.max(left, Math.max(leftDown, leftUp));
                }
            }

            int result = 0;
            for(int i = 0; i < n; i++){
                System.out.println(dp[i][m-1]);
                result = Math.max(result, dp[i][m-1]);
            }
            System.out.println(result);
        }
    }

}
/*
 [TC]
 2
 3 4
 1 3 3 2 2 1 4 1 0 6 4 7
 4 4
 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2

[풀어갔던 과정]
1. 처음에 탐색을 한 후에 결과를 dp 에 담아가는 방식으로 구현을 했었는데, 그렇게 하다보니 3가지 경우를 동시에 비교하는 것이 안됬다.
2. 3가지 경우를 동시에 찾은 후, 이 3가지를 모두 비교해서 가장 큰 값을 더해가는 방향으로 구현해야했다;
 */