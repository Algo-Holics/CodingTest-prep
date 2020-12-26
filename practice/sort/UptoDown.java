package chapter04_sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UptoDown {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Integer[] arr = new Integer[n];
		
		for(int i = 0; i< n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}

/*
[입력]
3
15
27
12

[참조 자료]
https://ifuwanna.tistory.com/232
*/
