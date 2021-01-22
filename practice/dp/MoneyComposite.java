package dp;

import java.math.BigInteger;
import java.util.Scanner;

class MoneyComposite {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }

        int[] dp = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            dp[i] = M;
            for (int j = 0; j < N; j++) {
                if (i - money[j] >= 0 && dp[i - money[j]] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
                }
            }
            if (dp[i] == M) {
                dp[i] = -1;
            }
        }

        System.out.println(dp[M]);
    }
}
