package chapter04_sort;

import java.util.Arrays;

public class SelectionSortTest {

	public static void main(String[] args) {
		int array[]= new int [10];
		for(int i = 0; i< array.length; i++) {
			array[i] = (int) (Math.random()* 10 + 1); 
		}
		
		System.out.print("선택 정렬 전: ");
		System.out.println(Arrays.toString(array));
		
		System.out.print("선택 정렬 후: ");
		System.out.println(Arrays.toString(selectionSort(array)));
	}
	public static int[] selectionSort(int[] arr) {
		for(int i = 0; i< arr.length -1 ; i++) {
			int min_idx = i;
			// 최소 인덱스 찾기
			for(int j = i + 1; j <arr.length; j++) {
				if(arr[min_idx] > arr[j]) {
					min_idx = j;
				}
			}
			//swap
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}

//최소 인덱스 위치를 찾아 swap