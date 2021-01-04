package chapter05_binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class MakingRiceCake {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int start = 0;
		int end = arr[n-1];
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			
			for(int i = 0; i < n ; i ++) {
				if(mid - arr[i]<= 0) sum += (mid - arr[i])*-1;
			}
			
			if(sum >= m) {
				result = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(result);
		
	}
}
