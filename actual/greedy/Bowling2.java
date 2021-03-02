package greedy;

import java.util.Scanner;

public class Bowling2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int ans = 0;
		int cnt[] = new int[M+1];
		
		for(int i = 0; i < N; i++) {
			cnt[sc.nextInt()]++;
		}
		
		for(int i = 1; i < M; i++) {
			N-=cnt[i];
			ans += cnt[i] * N;
		}
		
		System.out.println(ans);
	}

}
