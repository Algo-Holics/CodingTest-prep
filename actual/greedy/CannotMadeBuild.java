package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class CannotMadeBuild {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] money = new int[N];
		for(int i = 0; i < N; i++) {
			money[i] = sc.nextInt();
		}
		
		Arrays.sort(money);
		
		for(int i = 1; i <= 1000000000; i++) {
			if(!isVailable(i, money)) {
				System.out.println(i);
				break;
			}
		}
		
	}

	private static boolean isVailable(int num, int[] arr) {
		for(int i = arr.length-1; i >= 0; i--) {
			if(arr[i] <= num) {
				num -= arr[i];
			}
		}
		if(num == 0) {
			return true;
		}
		return false;
	}
}
/*주어진 tc는 다 통과하는데... 이렇게하면 모든 수를 고려할 수 없을 것 같다...*/
/*조합으로 풀자니, 시간복잡도 너무 올라갈거같아서, 참조했다*/
