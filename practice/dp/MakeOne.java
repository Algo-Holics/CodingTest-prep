package dp;

import java.util.Scanner;

class MakeOne {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int X = sc.nextInt();

        int[] dp = new int[30000];

        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }

        System.out.println(dp[26]);
    }
}
