package chapter04_sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReplaceElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Integer A[] = new Integer[n];
		for(int i = 0; i< n ;i++) {
			A[i] = sc.nextInt();
		}
		Integer B[] = new Integer[n];
		for(int i = 0; i< n; i++) {
			B[i] = sc.nextInt();
		}
		
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		for(int i = 0; i< k; i++) {
			if(A[i] < B[i]) {
				int temp = B[i];
				B[i] = A[i];
				A[i] = temp;
			}else {
				break;
			}
		}
		int sum = 0;
		for(int i: A) {
			sum += i;
		}
		System.out.println(sum);
	}
}

/*
[입력 예]
5 3
1 2 5 4 3
5 5 6 6 5
*/
