package dp;

import java.math.BigInteger;
import java.util.Scanner;

class FloorUnderConstruct {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();

        BigInteger[] dp = new BigInteger[1001];

        dp[1] = BigInteger.valueOf(1L);
        dp[2] = BigInteger.valueOf(3L);
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2L))).mod(BigInteger.valueOf(796796L));
        }

        System.out.println(dp[N]);
    }
}
