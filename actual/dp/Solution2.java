package algo.dp;

import java.util.Scanner;
//정수삼각형
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] tri = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                tri[i][j] = sc.nextInt();
            }
        }

        //bottom -> top (좌, 우 비교해서 큰값을 위에 계속 더해가는 방식으로 구현함)
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                tri[i-1][j] += Math.max(tri[i][j] , tri[i][j+1]);
            }
        }

        System.out.println(tri[0][0]);
    }
}
