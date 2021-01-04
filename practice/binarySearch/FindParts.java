package chapter05_binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindParts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int haveArr[] = new int[n];
		for(int i = 0; i < n ; i++) {
			haveArr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int findArr[] = new int[m];
		for(int i = 0; i < m ; i++) {
			findArr[i] = sc.nextInt();
		}
		
		Arrays.sort(haveArr);
		
		for(int i: findArr) {
			System.out.printf("%s ",binarySearch(haveArr, i, 0, n-1));
		}
	}

	private static String binarySearch(int[] haveArr, int findNum, int start, int end) {
		while(start <= end) {
			int mid = (start + end)/2;
			
			if(findNum == haveArr[mid]) return "yes";
			if(findNum < haveArr[mid]) {
				end = mid-1;
			}else {
				start = mid + 1;
			}
		}
		return "no";
	}
}

/*
[입력]
5
8 3 7 9 2
3
5 7 9 

[출력]
no yes yes
 */
