package chapter04_sort;

import java.util.Arrays;

public class BubbleSortTest {
	public static void main(String[] args) {
		int array[]= new int [10];
		for(int i = 0; i< array.length; i++) {
			array[i] = (int) (Math.random()* 10 + 1); 
		}
		System.out.print("버블 정렬 전: ");
		System.out.println(Arrays.toString(array));
		
		System.out.print("버블 정렬 후: ");
		System.out.println(Arrays.toString(bubbleSort(array)));
	}

	public static int[] bubbleSort(int[] arr) {
		for(int i = 0; i< arr.length - 1; i++) {
			for(int j = 0; j< arr.length - i -1; j++) {
				if(arr[j]> arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}

//인접한 두 값의 비교 후 작은 값이 앞으로 오도록