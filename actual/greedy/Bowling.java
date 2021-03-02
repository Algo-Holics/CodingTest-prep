package greedy;

import java.util.Scanner;

public class Bowling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int ans = 0;
		int bowlings[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			bowlings[i] = sc.nextInt();
		}
		// 블루투포스라고 생각되서 풀이 참조.
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				if(bowlings[i]!= bowlings[j]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}

}
