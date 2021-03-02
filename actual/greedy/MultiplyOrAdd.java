package greedy;

import java.util.Scanner;

public class MultiplyOrAdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		int ans = S.charAt(0) - '0';
		
		for(int i = 1; i < S.length(); i++) {
			int n = S.charAt(i) - '0';
			int prev = S.charAt(i-1) - '0';
			if(n <= 1 || ans <= 1) {
				ans += n;
			}else {
				ans *= n;
			}
		}
		
		System.out.println(ans);
	}
}
