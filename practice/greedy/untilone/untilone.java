package chapter01_greedy;

import java.util.Scanner;

public class untilone {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int cnt = 0;
		
		while (true) {
			if (n == 1) {
				break;
			}
			if (n % k == 0) {
				n /= k;
				cnt++;
				continue;
			}
			n -= k;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
