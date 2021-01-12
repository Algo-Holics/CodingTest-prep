package chapter06_dp;

import java.math.BigInteger;

public class Ex02 {
	public static BigInteger[] dp= new BigInteger[100]; 
	public static void main(String[] args) {
		for(int i = 0; i < dp.length; i++){
			dp[i] = BigInteger.ZERO;
		}
			
		System.out.println(fibo(99));
	}

	private static BigInteger fibo(int x) {
		if(x == 1 || x == 2) return BigInteger.ONE;
		
		if(dp[x] != BigInteger.ZERO) return dp[x];
		
		dp[x] = fibo(x-1).add(fibo(x-2));
		
		return dp[x];
	}
}
