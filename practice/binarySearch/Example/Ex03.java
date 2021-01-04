package chapter05_binarySearch;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int target = sc.nextInt();
		
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		int result = binarySearch(array, target, 0, n-1);
		System.out.println(result == -1 ? "원소 존재 하지 않음" : result);
	}

	private static int binarySearch(int[] array, int target, int start, int end) {
		
		while(start <= end) {
			int mid = (start + end) /2 ;
			if(array[mid] == target) return mid + 1 ;
			if(array[mid] < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
