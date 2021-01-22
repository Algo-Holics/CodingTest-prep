package dp;

import java.util.Scanner;

class AntWorrier {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();

        int[] warehouse = new int[N];
        for (int i = 0; i < N; i++) {
            warehouse[i] = sc.nextInt();
        }

        int[] dp = new int[101];

        dp[0] = warehouse[0];

        for (int i = 1; i < N; i++) {
            dp[i] = warehouse[i];
            if (i - 2 >= 0) {
                dp[i] = Math.max(dp[i], dp[i - 2] + warehouse[i]);
            }
            if (i - 3 >= 0) {
                dp[i] = Math.max(dp[i], dp[i - 3] + warehouse[i]);
            }
        }

        System.out.println(dp[N - 1]);
    }
}
