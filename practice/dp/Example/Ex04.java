package chapter06_dp;

import java.math.BigInteger;

public class Ex04 {
	public static BigInteger[] dp= new BigInteger[100]; 
	public static void main(String[] args) {
		for(int i = 0; i < dp.length; i++){
			dp[i] = BigInteger.ZERO;
		}
		dp[1] = BigInteger.ONE; 
		dp[2] = BigInteger.ONE;
		int n = 99;
		
		for(int i = 3; i < n+1; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		System.out.println(dp[n]);
	}
}
