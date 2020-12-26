package chapter04_sort;

import java.util.Arrays;

public class JavaBasicSortTest {
	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		Arrays.sort(arr);
	
		System.out.println(Arrays.toString(arr));
	}
}
