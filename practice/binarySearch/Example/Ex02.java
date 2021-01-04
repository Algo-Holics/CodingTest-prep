package chapter05_binarySearch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int target = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int result = binary_search(arr, target, 0, n-1);
	
		System.out.println(result == -1? "원소가 존재 하지 않습니다.": result+1);
		
		sc.close();
	}

	private static int binary_search(int[] arr, int target, int start, int end) {
		if(start> end) return -1;
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == target) {
			return mid;
		}else if(arr[mid]> target) {
			return binary_search(arr, target, start, mid-1);
		}else {
			return binary_search(arr, target, mid+1, end);
		}
	}
}
