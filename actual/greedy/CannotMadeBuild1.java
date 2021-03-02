package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class CannotMadeBuild1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] money = new int[N];
		for(int i = 0; i < N; i++) {
			money[i] = sc.nextInt();
		}
		
		Arrays.sort(money);
		
		int target = 1;
		
		for(int m: money) {
			if(target >= m) {
				target += m;
			}else {
				break;
			}
		}
		
		System.out.println(target);
	}

}
